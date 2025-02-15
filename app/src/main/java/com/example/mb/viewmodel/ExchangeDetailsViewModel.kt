package com.example.mb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mb.repository.ExchangeRepository
import com.example.mb.viewmodel.action.ExchangeDetailsViewAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeDetailsViewModel @Inject constructor(
    private val repository: ExchangeRepository
) : ViewModel() {

    private val _exchangeDetails = MutableStateFlow<ExchangeDetailsViewAction>(
        ExchangeDetailsViewAction.Loading
    )
    val exchangeDetails = _exchangeDetails.asStateFlow()

    fun fetchExchangeDetails(exchange: String) {
        viewModelScope.launch {
            _exchangeDetails.value = ExchangeDetailsViewAction.Loading
            try {
                val response = repository.getDetailsExchange(exchange)
                if (response != null) {
                    _exchangeDetails.value =
                        ExchangeDetailsViewAction.OpenDetailsExchangeDetails(response)
                } else {
                    _exchangeDetails.value = ExchangeDetailsViewAction.ErrorExchangeDetails(
                        "Falha ao obter dados!"
                    )
                }
            } catch (e: Exception) {
                _exchangeDetails.value = ExchangeDetailsViewAction.ErrorExchangeDetails(
                    "Erro ao carregar: ${e.message}"
                )
            }
        }
    }
}
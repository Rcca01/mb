package com.example.mb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mb.repository.ExchangeRepository
import com.example.mb.viewmodel.action.ExchangeViewAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeViewModel @Inject constructor(
    private val repository: ExchangeRepository
) : ViewModel() {

    private val _listExchanges = MutableStateFlow<ExchangeViewAction>(
        ExchangeViewAction.Loading
    )
    val listExchanges = _listExchanges.asStateFlow()

    init {
        fetchExchanges()
    }

    fun fetchExchanges() {
        viewModelScope.launch {
            _listExchanges.value = ExchangeViewAction.Loading
            try {
                val response = repository.getBitcoinPrice()
                _listExchanges.value = ExchangeViewAction.Success(response)
            } catch (e: Exception) {
                _listExchanges.value = ExchangeViewAction.Error(
                    errorMessage = "Erro ao carregar: ${e.message}"
                )
            }
        }
    }
}
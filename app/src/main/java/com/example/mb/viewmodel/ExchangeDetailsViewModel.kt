package com.example.mb.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mb.repository.ExchangeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ExchangeDetailsViewModel @Inject constructor(
    private val repository: ExchangeRepository
) : ViewModel() {

    private val _exchangeDetails = MutableSharedFlow<ExchangeViewAction>()
    val exchangeDetails = _exchangeDetails.asSharedFlow()

    fun fetchExchangeDetails(exchange: String) {
        viewModelScope.launch {
            sendAction(ExchangeViewAction.Loading(true))
            try {
                val response = repository.getDetailsExchange(exchange)
                if (response != null) {
                    sendAction(ExchangeViewAction.OpenDetailsExchange(response))
                } else {
                    sendAction(ExchangeViewAction.ErrorExchange("Falha ao obter dados!"))
                }
                sendAction(ExchangeViewAction.Loading(false))
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun sendAction(action: ExchangeViewAction) = viewModelScope.launch {
        _exchangeDetails.emit(action)
    }
}
package com.example.mb.viewmodel

import com.example.mb.data.model.ExchangeDataEntity

sealed class ExchangeViewAction {
    data class Loading(val status: Boolean) : ExchangeViewAction()
    data class OpenDetailsExchange(val exchangeDetails: ExchangeDataEntity) : ExchangeViewAction()
    data class ErrorExchange(val message: String) : ExchangeViewAction()
}
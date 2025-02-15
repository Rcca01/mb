package com.example.mb.viewmodel

import com.example.mb.data.model.ExchangeDataEntity

sealed class ExchangeDetailsViewAction {
    data class Loading(val status: Boolean) : ExchangeDetailsViewAction()
    data class OpenDetailsExchangeDetails(val exchangeDetails: ExchangeDataEntity) : ExchangeDetailsViewAction()
    data class ErrorExchangeDetails(val message: String) : ExchangeDetailsViewAction()
}
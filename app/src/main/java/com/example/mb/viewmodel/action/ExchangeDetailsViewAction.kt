package com.example.mb.viewmodel.action

import com.example.mb.data.model.ExchangeDataEntity

sealed class ExchangeDetailsViewAction {
    object Loading : ExchangeDetailsViewAction()
    data class OpenDetailsExchangeDetails(val exchangeDetails: ExchangeDataEntity) : ExchangeDetailsViewAction()
    data class ErrorExchangeDetails(val message: String) : ExchangeDetailsViewAction()
}
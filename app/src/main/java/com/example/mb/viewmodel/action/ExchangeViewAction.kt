package com.example.mb.viewmodel.action

import com.example.mb.data.model.ExchangeDataEntity

sealed class ExchangeViewAction {
    object Loading: ExchangeViewAction()
    data class Success(val list: List<ExchangeDataEntity>): ExchangeViewAction()
    data class Error(val errorMessage: String): ExchangeViewAction()
}
package com.example.mb.viewmodel

import com.example.mb.data.model.ExchangeDataEntity

sealed class ExchangeViewAction {
    data class Loading(val status: Boolean): ExchangeViewAction()
    data class Success(val list: List<ExchangeDataEntity>): ExchangeViewAction()
    data class Error(val errorMessage: String): ExchangeViewAction()
}
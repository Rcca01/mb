package com.example.mb.data.model

data class ExchangeDataEntity(
    val name: String,
    val exchangeId: String,
    val dataQuoteStart: String,
    val dataQuoteEnd: String,
    val dataOrderBookStart: String,
    val dataOrderBookEnd: String,
    val dataTradeStart: String,
    val dataTradeEnd: String,
    val dataSymbolsCount: String,
    val volume1hrsUsd: String,
    val volume1DayUsd: String,
    val volume1mthUsd: String,
    val rank: String
)
package com.example.mb.utils

import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.data.model.ExchangeDataResponse

fun mockedExchangeDataEntity() = ExchangeDataEntity(
    name = "Binance",
    exchangeId = "binance",
    dataQuoteStart = "2025-12-31 23:44",
    dataQuoteEnd = "2025-01-09 21:00",
    dataOrderBookStart = "",
    dataOrderBookEnd = "2025-06-30 09:00",
    dataTradeStart = "2025-12-31 23:44",
    dataTradeEnd = "2025-01-09 21:00",
    dataSymbolsCount = "100",
    volume1hrsUsd = "50,000.5",
    volume1DayUsd = "1,000,000.75",
    volume1mthUsd = "1,000,000.75",
    rank = "1"
)

fun mockedExchangeDataResponse() = ExchangeDataResponse(
    exchangeId = "binance",
    name = "Binance",
    dataQuoteStart = "2025-12-31T23:59:59.9876543Z",
    dataQuoteEnd = "2025-01-10T00:00:00.0000000Z",
    dataOrderBookStart = null,
    dataOrderBookEnd = "2025-06-30T12:00:00.0000000Z",
    dataTradeStart = "2025-12-31T23:59:59.9876543Z",
    dataTradeEnd = "2025-01-10T00:00:00.0000000Z",
    dataSymbolsCount = 100,
    volume1hrsUsd = 50000.5,
    volume1DayUsd = 1000000.75,
    volume1mthUsd = 30000000.99,
    rank = 1
)
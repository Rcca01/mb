package com.example.mb.data.model

import com.google.gson.annotations.SerializedName

data class ExchangeDataResponse(
    @SerializedName("exchange_id") val exchangeId: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("data_quote_start") val dataQuoteStart: String?,
    @SerializedName("data_quote_end") val dataQuoteEnd: String?,
    @SerializedName("data_orderbook_start") val dataOrderBookStart: String?,
    @SerializedName("data_orderbook_end") val dataOrderBookEnd: String?,
    @SerializedName("data_trade_start") val dataTradeStart: String?,
    @SerializedName("data_trade_end") val dataTradeEnd: String?,
    @SerializedName("data_symbols_count") val dataSymbolsCount: Int?,
    @SerializedName("volume_1hrs_usd") val volume1hrsUsd: Double?,
    @SerializedName("volume_1day_usd") val volume1DayUsd: Double?,
    @SerializedName("volume_1mth_usd") val volume1mthUsd: Double?,
    @SerializedName("rank") val rank: Int?
)
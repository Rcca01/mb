package com.example.mb.data.model

import com.google.gson.annotations.SerializedName

data class ExchangeDataResponse(
    @SerializedName("name") val name: String?,
    @SerializedName("exchange_id") val exchangeId: String?,
    @SerializedName("volume_1day_usd") val volume1DayUsd: Double?
)

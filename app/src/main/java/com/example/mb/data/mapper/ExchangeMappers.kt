package com.example.mb.data.mapper

import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.data.model.ExchangeDataResponse
import java.text.NumberFormat
import java.util.Locale

fun ExchangeDataResponse.mapToEntity() = ExchangeDataEntity(
    name = name.orEmpty(),
    exchangeId = exchangeId.orEmpty(),
    volume1DayUsd = parseValueToUSA(volume1DayUsd)
)

private fun parseValueToUSA(usaValue: Double?): String {
    val formatUSA = NumberFormat.getNumberInstance(Locale.US)
    return formatUSA.format(usaValue)
}
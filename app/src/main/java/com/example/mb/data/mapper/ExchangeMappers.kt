package com.example.mb.data.mapper

import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.data.model.ExchangeDataResponse
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

const val EMPTY_STRING = ""

fun ExchangeDataResponse.mapToEntity() = ExchangeDataEntity(
    name = name.orEmpty(),
    exchangeId = exchangeId.orEmpty(),
    dataQuoteStart = dataQuoteStart?.let { parseData(dataQuoteStart) } ?: EMPTY_STRING,
    dataQuoteEnd = dataQuoteEnd?.let { parseData(dataQuoteEnd) } ?: EMPTY_STRING,
    dataOrderBookStart = dataOrderBookStart?.let { parseData(dataOrderBookStart) } ?: EMPTY_STRING,
    dataOrderBookEnd = dataOrderBookEnd?.let { parseData(dataOrderBookEnd) } ?: EMPTY_STRING,
    dataTradeStart = dataTradeStart?.let { parseData(dataTradeStart) } ?: EMPTY_STRING,
    dataTradeEnd = dataTradeEnd?.let { parseData(dataTradeEnd) } ?: EMPTY_STRING,
    dataSymbolsCount = dataSymbolsCount.toString(),
    volume1hrsUsd = parseValueToUSA(volume1hrsUsd),
    volume1DayUsd = parseValueToUSA(volume1DayUsd),
    volume1mthUsd = parseValueToUSA(volume1DayUsd),
    rank = rank.toString(),
)

private fun parseValueToUSA(usaValue: Double?): String {
    val formatUSA = NumberFormat.getNumberInstance(Locale.US)
    return formatUSA.format(usaValue)
}

private fun parseData(dataValue: String): String{
    return try {
        // Definir o formato da data original (ISO 8601 com UTC)
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSSSSS'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC") // Definir o fuso horário correto

        // Definir o formato de saída desejado
        val outputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())

        // Converter a String para Date e formatar para o novo formato
        val date: Date? = inputFormat.parse(dataValue)
        date?.let { outputFormat.format(it) } ?: "Data inválida"
    } catch (e: Exception) {
        e.printStackTrace()
        "Erro ao formatar data"
    }
}
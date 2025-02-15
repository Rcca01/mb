package com.example.mb.mapper

import com.example.mb.data.mapper.mapToEntity
import com.example.mb.data.mapper.parseData
import com.example.mb.data.mapper.parseValueToUSA
import com.example.mb.utils.mockedExchangeDataResponse
import org.junit.Assert
import org.junit.Test

class ExchangeDataMapperTest {

    @Test
    fun `mapToEntity should correctly map ExchangeDataResponse to ExchangeDataEntity`() {
        val response = mockedExchangeDataResponse()

        val entity = response.mapToEntity()

        Assert.assertEquals(entity.exchangeId, "binance")
        Assert.assertEquals(entity.name, "Binance")
        Assert.assertEquals(entity.dataQuoteStart, "2025-12-31 23:44")
        Assert.assertEquals(entity.dataQuoteEnd, "2025-01-09 21:00")
        Assert.assertEquals(entity.dataOrderBookStart, "")
        Assert.assertEquals(entity.dataOrderBookEnd, "2025-06-30 09:00")
        Assert.assertEquals(entity.volume1hrsUsd, "50,000.5")
        Assert.assertEquals(entity.volume1DayUsd, "1,000,000.75")
        Assert.assertEquals(entity.volume1mthUsd, "1,000,000.75")
        Assert.assertEquals(entity.rank, "1")
    }

    @Test
    fun `parseData should correctly format ISO 8601 date`() {
        val input = "2025-02-15T14:30:45.1234567Z"
        val expectedOutput = "2025-02-15 11:51"

        val result = parseData(input)
        Assert.assertEquals(result, expectedOutput)
    }

    @Test
    fun `parseData should return error message for invalid date`() {
        val invalidInput = "invalid-date"
        val result = parseData(invalidInput)

        Assert.assertEquals(result, "Erro ao formatar data")
    }

    @Test
    fun `parseValueToUSA should format double values in US format`() {
        val result = parseValueToUSA(1234567.89)
        Assert.assertEquals(result, "1,234,567.89")
    }

    @Test
    fun `parseValueToUSA should handle null values`() {
        val result = parseValueToUSA(null)
        Assert.assertEquals(result, "0")
    }
}

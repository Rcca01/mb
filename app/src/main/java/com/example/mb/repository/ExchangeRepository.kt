package com.example.mb.repository

import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.data.mapper.mapToEntity
import com.example.mb.service.CoinApiService
import javax.inject.Inject

class ExchangeRepository @Inject constructor(
    private val apiService: CoinApiService
) {
    suspend fun getBitcoinPrice(): List<ExchangeDataEntity> {
        return apiService.getExchange().map {
            it.mapToEntity()
        }
    }

    suspend fun getDetailsExchange(exchange: String): ExchangeDataEntity? {
        return apiService.getDetailsExchange(exchange)
            .firstOrNull()?.mapToEntity()
    }
}
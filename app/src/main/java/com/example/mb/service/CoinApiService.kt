package com.example.mb.service

import com.example.mb.data.model.ExchangeDataResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinApiService {
    @GET("v1/exchanges")
    suspend fun getExchange(): List<ExchangeDataResponse>

    @GET("v1/exchanges/{exchange_id}")
    suspend fun getDetailsExchange(
        @Path("exchange_id") exchangeId: String
    ): List<ExchangeDataResponse>
}
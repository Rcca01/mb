package com.example.mb.service

import com.example.mb.BuildConfig.COIN_API_KEY
import com.example.mb.data.model.ExchangeDataResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface CoinApiService {
    @Headers("X-CoinAPI-Key: $COIN_API_KEY")
    @GET("v1/exchanges")
    suspend fun getExchange(): List<ExchangeDataResponse>

    @Headers("X-CoinAPI-Key: $COIN_API_KEY")
    @GET("v1/exchanges/{exchange_id}")
    suspend fun getDetailsExchange(
        @Path("exchange_id") exchangeId: String
    ): List<ExchangeDataResponse>
}
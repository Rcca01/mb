package com.example.mb.service

import com.example.mb.BuildConfig.COIN_API_KEY
import com.example.mb.data.model.ExchangeDataResponse
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoinApiService {
    @Headers("X-CoinAPI-Key: $COIN_API_KEY")
    @GET("v1/exchanges")
    suspend fun getExchange(): List<ExchangeDataResponse>
}
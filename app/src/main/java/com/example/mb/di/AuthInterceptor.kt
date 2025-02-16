package com.example.mb.di

import com.example.mb.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response

class AuthInterceptor(private val apiKey: String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-CoinAPI-Key", apiKey)
            .build()
        return chain.proceed(request)
    }
}

fun okHttpClient(): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(AuthInterceptor(BuildConfig.COIN_API_KEY))
    .build()
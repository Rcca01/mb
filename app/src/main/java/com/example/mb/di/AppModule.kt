package com.example.mb.di

import com.example.mb.repository.ExchangeRepository
import com.example.mb.service.CoinApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://rest.coinapi.io/"

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideCoinApiService(retrofit: Retrofit): CoinApiService {
        return retrofit.create(CoinApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideCryptoRepository(apiService: CoinApiService): ExchangeRepository {
        return ExchangeRepository(apiService)
    }
}

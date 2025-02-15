package com.example.mb.repository

import com.example.mb.MainCoroutineRule
import com.example.mb.data.model.ExchangeDataResponse
import com.example.mb.service.CoinApiService
import com.example.mb.utils.mockedExchangeDataEntity
import com.example.mb.utils.mockedExchangeDataResponse
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ExchangeRepositoryTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var repository: ExchangeRepository

    @MockK
    private lateinit var apiService: CoinApiService

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        repository = ExchangeRepository(apiService)
    }

    @Test
    fun `getBitcoinPrice should return a list of ExchangeDataEntity when apiService returns data`() =
        runTest {
            val mockApiResponse = listOf(mockedExchangeDataResponse())
            val expectedEntityList = listOf(mockedExchangeDataEntity())

            coEvery { apiService.getExchange() } returns mockApiResponse

            val result = repository.getBitcoinPrice()

            assertEquals(expectedEntityList, result)
        }

    @Test
    fun `getDetailsExchange should return ExchangeDataEntity when apiService returns data`() =
        runTest {
            val exchange = "Bitcoin"
            val mockApiResponse = listOf(mockedExchangeDataResponse())
            val expectedEntity = mockedExchangeDataEntity()

            coEvery { apiService.getDetailsExchange(exchange) } returns mockApiResponse

            val result = repository.getDetailsExchange(exchange)

            assertEquals(expectedEntity, result)
        }

    @Test
    fun `getDetailsExchange should return null when apiService returns empty list`() =
        runTest {
            val exchange = "Bitcoin"
            val mockApiResponse = emptyList<ExchangeDataResponse>()

            coEvery { apiService.getDetailsExchange(exchange) } returns mockApiResponse

            val result = repository.getDetailsExchange(exchange)

            assertNull(result)
        }
}

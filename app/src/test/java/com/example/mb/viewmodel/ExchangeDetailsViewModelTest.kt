package com.example.mb.viewmodel

import com.example.mb.MainCoroutineRule
import com.example.mb.repository.ExchangeRepository
import com.example.mb.utils.mockedExchangeDataEntity
import com.example.mb.viewmodel.action.ExchangeDetailsViewAction
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ExchangeDetailsViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ExchangeDetailsViewModel

    @MockK
    private lateinit var repository: ExchangeRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = ExchangeDetailsViewModel(repository)
    }

    @Test
    fun `getDetailsExchange should return ExchangeDataEntity when API returns data`() = runTest {
        val exchangeName = "Binance"

        val fakeExchange = mockedExchangeDataEntity().copy(name = exchangeName)

        coEvery { repository.getDetailsExchange(exchangeName) } returns fakeExchange

        viewModel.fetchExchangeDetails(exchangeName)

        val states = viewModel.exchangeDetails.take(2).toList()
        Assert.assertEquals(ExchangeDetailsViewAction.Loading, states[0])
        Assert.assertEquals(
            ExchangeDetailsViewAction.OpenDetailsExchangeDetails(fakeExchange),
            states[1]
        )
    }

    @Test
    fun `getDetailsExchange should return null when API returns empty list`() = runTest {
        val exchangeName = "UnknownExchange"

        coEvery { repository.getDetailsExchange(exchangeName) } returns null

        viewModel.fetchExchangeDetails(exchangeName)

        val states = viewModel.exchangeDetails.take(2).toList()
        Assert.assertEquals(ExchangeDetailsViewAction.Loading, states[0])
        Assert.assertEquals(
            ExchangeDetailsViewAction.ErrorExchangeDetails(
                "Falha ao obter dados!"
            ), states[1]
        )
    }

    @Test
    fun `getDetailsExchange should handle API errors`() = runTest {

        val errorMessage = "Erro na API"
        val exchangeName = "Binance"

        coEvery { repository.getDetailsExchange(exchangeName) } throws Exception(errorMessage)

        viewModel.fetchExchangeDetails(exchangeName)

        val states = viewModel.exchangeDetails.take(2).toList()
        Assert.assertEquals(ExchangeDetailsViewAction.Loading, states[0])
        Assert.assertEquals(
            ExchangeDetailsViewAction.ErrorExchangeDetails(
                "Erro ao carregar: $errorMessage"
            ), states[1]
        )
    }
}
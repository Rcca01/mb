package com.example.mb.viewmodel

import com.example.mb.MainCoroutineRule
import com.example.mb.repository.ExchangeRepository
import com.example.mb.utils.mockedExchangeDataEntity
import com.example.mb.viewmodel.action.ExchangeViewAction
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class ExchangeViewModelTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ExchangeViewModel

    @MockK(relaxed = true)
    private lateinit var repository: ExchangeRepository

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        viewModel = ExchangeViewModel(repository)
    }

    @Test
    fun `fetchExchanges should emit Loading and then Success when repository returns data`() =
        runTest {
            val fakeExchanges = listOf(
                mockedExchangeDataEntity()
            )
            coEvery { repository.getBitcoinPrice() } returns fakeExchanges

            viewModel.fetchExchanges()

            val states = viewModel.listExchanges.take(2).toList()
            assertEquals(ExchangeViewAction.Success(fakeExchanges), states[1])
        }

    @Test
    fun `fetchExchanges should emit Loading and then Error when repository throws an exception`() =
        runTest {
            val errorMessage = "Erro na API"
            coEvery { repository.getBitcoinPrice() } throws Exception(errorMessage)

            viewModel.fetchExchanges()

            val states = viewModel.listExchanges.take(2).toList()
            assertTrue(states[1] is ExchangeViewAction.Error)
            assertEquals(
                "Erro ao carregar: $errorMessage",
                (states[1] as ExchangeViewAction.Error).errorMessage
            )
        }
}
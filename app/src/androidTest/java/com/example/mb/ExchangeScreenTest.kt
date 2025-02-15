package com.example.mb

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.navigation.compose.rememberNavController
import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.ui.ExchangeScreen
import com.example.mb.viewmodel.ExchangeViewModel
import com.example.mb.viewmodel.action.ExchangeViewAction
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.junit.Before
import org.junit.Test

@RunWith(JUnit4::class)
class ExchangeScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: ExchangeViewModel
    private val mockStateFlow = MutableStateFlow<ExchangeViewAction>(ExchangeViewAction.Loading)

    @Before
    fun setup() {
        viewModel = mockk()

        every { viewModel.listExchanges } returns mockStateFlow

        composeTestRule.setContent {
            ExchangeScreen(navController = rememberNavController(), viewModel = viewModel)
        }
    }

    @Test
    fun testLoadingState() {
        composeTestRule.onNodeWithTag("loading").assertIsDisplayed()
    }

    @Test
    fun testSuccessState() {
        // Altera o fluxo para emular sucesso
        mockStateFlow.value = ExchangeViewAction.Success(
            listOf(
                ExchangeDataEntity(
                    name = "",
                    exchangeId = "",
                    dataQuoteStart = "",
                    dataQuoteEnd = "",
                    dataOrderBookStart = "",
                    dataOrderBookEnd = "",
                    dataTradeStart = "",
                    dataTradeEnd = "",
                    dataSymbolsCount = "",
                    volume1hrsUsd = "",
                    volume1DayUsd = "",
                    volume1mthUsd = "",
                    rank = ""
                )
            )
        )

        // Verifica se o conteúdo do sucesso está sendo exibido
        composeTestRule.onNodeWithTag("listExchange").assertIsDisplayed()
    }

    @Test
    fun testErrorState() {
        // Altera o fluxo para emular erro
        mockStateFlow.value = ExchangeViewAction.Error("Erro ao carregar dados")

        // Verifica se a mensagem de erro é exibida
        composeTestRule.onNodeWithText("Erro ao carregar dados").assertIsDisplayed()
    }
}
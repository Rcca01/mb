package com.example.mb

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.NavController
import androidx.navigation.testing.TestNavHostController
import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.ui.ExchangeDetailScreen
import com.example.mb.viewmodel.ExchangeDetailsViewModel
import com.example.mb.viewmodel.action.ExchangeDetailsViewAction
import io.mockk.*
import kotlinx.coroutines.flow.MutableStateFlow
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class ExchangeDetailScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private lateinit var viewModel: ExchangeDetailsViewModel
    private lateinit var navController: NavController
    private val exchange = "test-exchange"
    private val mockStateFlow =
        MutableStateFlow<ExchangeDetailsViewAction>(ExchangeDetailsViewAction.Loading)

    @Before
    fun setup() {
        viewModel = mockk(relaxed = true)
        every { viewModel.exchangeDetails } returns mockStateFlow
        every { viewModel.fetchExchangeDetails(any()) } just Runs

        composeTestRule.setContent {
            val context = LocalContext.current
            navController = TestNavHostController(context)
            ExchangeDetailScreen(
                navController = navController, exchange = exchange, viewModel = viewModel
            )
        }


    }

    @Test
    fun testLoadingStateIsDisplayed() {
        composeTestRule.onNodeWithTag("loading").assertIsDisplayed()
    }

    @Test
    fun testErrorStateIsDisplayed() {
        mockStateFlow.value = ExchangeDetailsViewAction.ErrorExchangeDetails("Network Error")
        composeTestRule.onNodeWithTag("error_screen").assertIsDisplayed()
    }

    @Test
    fun testDetailsAreDisplayed() {
        val fakeDetails = ExchangeDataEntity(
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
        mockStateFlow.value = ExchangeDetailsViewAction.OpenDetailsExchangeDetails(fakeDetails)
        composeTestRule.onNodeWithTag("exchange_details").assertIsDisplayed()
    }
}
package com.example.mb.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mb.ui.component.ErrorScreen
import com.example.mb.ui.component.ExchangeDetails
import com.example.mb.ui.component.Loading
import com.example.mb.viewmodel.ExchangeDetailsViewModel
import com.example.mb.viewmodel.action.ExchangeDetailsViewAction

@Composable
fun ExchangeDetailScreen(
    navController: NavController,
    exchange: String,
    viewModel: ExchangeDetailsViewModel = hiltViewModel()
) {

    val uiState by viewModel.exchangeDetails.collectAsState(
        ExchangeDetailsViewAction.Loading
    )

    LaunchedEffect(Unit) {
        viewModel.fetchExchangeDetails(exchange)
    }

    when (uiState) {
        is ExchangeDetailsViewAction.Loading -> Loading()

        is ExchangeDetailsViewAction.ErrorExchangeDetails -> ErrorScreen(
            onRetry = { viewModel.fetchExchangeDetails(exchange) },
            errorMessage = (uiState as ExchangeDetailsViewAction.ErrorExchangeDetails).message
        )

        is ExchangeDetailsViewAction.OpenDetailsExchangeDetails -> ExchangeDetails(
            navController = navController,
            exchangeDetails = (uiState as ExchangeDetailsViewAction.OpenDetailsExchangeDetails).exchangeDetails
        )
    }
}

package com.example.mb.ui

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mb.ui.component.ErrorScreen
import com.example.mb.ui.component.ExchangeListScreen
import com.example.mb.ui.component.Loading
import com.example.mb.viewmodel.ExchangeViewAction
import com.example.mb.viewmodel.ExchangeViewModel

@Composable
fun ExchangeScreen(
    navController: NavController,
    viewModel: ExchangeViewModel = hiltViewModel()
) {
    val uiState by viewModel.listExchanges.collectAsState(ExchangeViewAction.Loading(true))

    when (uiState) {
        is ExchangeViewAction.Loading -> Loading()

        is ExchangeViewAction.Success -> ExchangeListScreen(
            navController,
            (uiState as ExchangeViewAction.Success).list
        )

        is ExchangeViewAction.Error -> ErrorScreen(
                onRetry = { viewModel.fetchExchanges() },
                errorMessage = (uiState as ExchangeViewAction.Error).errorMessage
            )
    }
}

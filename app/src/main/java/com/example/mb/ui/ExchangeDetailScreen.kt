package com.example.mb.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mb.R
import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.ui.component.Loading
import com.example.mb.ui.theme.Dimens
import com.example.mb.viewmodel.ExchangeDetailsViewModel
import com.example.mb.viewmodel.ExchangeDetailsViewAction

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeDetailScreen(
    navController: NavController,
    exchange: String,
    viewModel: ExchangeDetailsViewModel = hiltViewModel()
) {

    var isLoading by remember { mutableStateOf(true) }
    var exchangeDetails by remember { mutableStateOf<ExchangeDataEntity?>(null) }

    LaunchedEffect(Unit) {
        viewModel.fetchExchangeDetails(exchange)
        viewModel.exchangeDetails.collect { event ->
            when (event) {
                is ExchangeDetailsViewAction.Loading -> {
                    isLoading = event.status
                }

                is ExchangeDetailsViewAction.ErrorExchangeDetails -> {
                    isLoading = false
                }

                is ExchangeDetailsViewAction.OpenDetailsExchangeDetails -> {
                    exchangeDetails = event.exchangeDetails
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(exchangeDetails?.name ?: "...") },
                navigationIcon = { BackButton(navController) }
            )
        }
    ) { padding ->
        if (isLoading) {
            Loading()
        }
        if (exchangeDetails != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(Dimens.MediumPadding)
            ) {
                Text(
                    text = stringResource(R.string.id, exchangeDetails!!.exchangeId),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(R.string.name, exchangeDetails!!.name),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(
                        R.string.data_quote_start,
                        exchangeDetails!!.dataQuoteStart
                    ), style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(R.string.data_quote_end, exchangeDetails!!.dataQuoteEnd),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(
                        R.string.data_orderbook_start,
                        exchangeDetails!!.dataOrderBookStart
                    ), style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(
                        R.string.data_orderbook_end,
                        exchangeDetails!!.dataOrderBookEnd
                    ), style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(
                        R.string.data_trade_start,
                        exchangeDetails!!.dataTradeStart
                    ), style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(R.string.data_trade_end, exchangeDetails!!.dataTradeEnd),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(
                        R.string.data_symbols_count,
                        exchangeDetails!!.dataSymbolsCount
                    ), style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(
                        R.string.volume_1hrs_usd,
                        exchangeDetails!!.volume1hrsUsd
                    ), style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(
                        R.string.volume_1day_usd,
                        exchangeDetails!!.volume1DayUsd
                    ), style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(
                        R.string.volume_1mth_usd,
                        exchangeDetails!!.volume1mthUsd
                    ), style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = stringResource(R.string.rank, exchangeDetails!!.rank),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }

    }
}

@Composable
fun BackButton(navController: NavController) {
    IconButton(onClick = { navController.popBackStack() }) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.back)
        )
    }
}

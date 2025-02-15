package com.example.mb.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.mb.R
import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.ui.theme.Dimens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeDetails(
    navController: NavController,
    exchangeDetails: ExchangeDataEntity
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(exchangeDetails.name) },
                navigationIcon = { BackButton(navController) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(Dimens.MediumPadding)
                .testTag("exchange_details")
        ) {
            Text(
                text = stringResource(R.string.id, exchangeDetails.exchangeId),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(R.string.name, exchangeDetails.name),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(
                    R.string.data_quote_start,
                    exchangeDetails.dataQuoteStart
                ), style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(R.string.data_quote_end, exchangeDetails.dataQuoteEnd),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(
                    R.string.data_orderbook_start,
                    exchangeDetails.dataOrderBookStart
                ), style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(
                    R.string.data_orderbook_end,
                    exchangeDetails.dataOrderBookEnd
                ), style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(
                    R.string.data_trade_start,
                    exchangeDetails.dataTradeStart
                ), style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(R.string.data_trade_end, exchangeDetails.dataTradeEnd),
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(
                    R.string.data_symbols_count,
                    exchangeDetails.dataSymbolsCount
                ), style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(
                    R.string.volume_1hrs_usd,
                    exchangeDetails.volume1hrsUsd
                ), style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(
                    R.string.volume_1day_usd,
                    exchangeDetails.volume1DayUsd
                ), style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(
                    R.string.volume_1mth_usd,
                    exchangeDetails.volume1mthUsd
                ), style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = stringResource(R.string.rank, exchangeDetails.rank),
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
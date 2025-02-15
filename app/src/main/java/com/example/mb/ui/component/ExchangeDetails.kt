package com.example.mb.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
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
                title = { Text(exchangeDetails.name, fontWeight = FontWeight.Bold) },
                navigationIcon = { BackButton(navController) }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(Dimens.dimen16dp)
                .verticalScroll(rememberScrollState())
                .testTag("exchange_details"),
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(Dimens.dimen12dp),
                elevation = CardDefaults.cardElevation(defaultElevation = Dimens.dimen6dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant)
            ) {
                Column(
                    modifier = Modifier.padding(Dimens.dimen16dp)
                ) {
                    InfoRow(title = stringResource(R.string.id), value = exchangeDetails.exchangeId)
                    InfoRow(title = stringResource(R.string.name), value = exchangeDetails.name)
                    Divider(modifier = Modifier.padding(vertical = Dimens.dimen8dp))

                    InfoRow(
                        title = stringResource(R.string.data_quote_start),
                        value = exchangeDetails.dataQuoteStart
                    )
                    InfoRow(
                        title = stringResource(R.string.data_quote_end),
                        value = exchangeDetails.dataQuoteEnd
                    )
                    Divider(modifier = Modifier.padding(vertical = Dimens.dimen8dp))

                    InfoRow(
                        title = stringResource(R.string.data_orderbook_start),
                        value = exchangeDetails.dataOrderBookStart
                    )
                    InfoRow(
                        title = stringResource(R.string.data_orderbook_end),
                        value = exchangeDetails.dataOrderBookEnd
                    )
                    Divider(modifier = Modifier.padding(vertical = Dimens.dimen8dp))

                    InfoRow(
                        title = stringResource(R.string.data_trade_start),
                        value = exchangeDetails.dataTradeStart
                    )
                    InfoRow(
                        title = stringResource(R.string.data_trade_end),
                        value = exchangeDetails.dataTradeEnd
                    )
                    Divider(modifier = Modifier.padding(vertical = Dimens.dimen8dp))

                    InfoRow(
                        title = stringResource(R.string.data_symbols_count),
                        value = exchangeDetails.dataSymbolsCount
                    )
                    InfoRow(
                        title = stringResource(R.string.volume_1hrs_usd),
                        value = "$${exchangeDetails.volume1hrsUsd}"
                    )
                    InfoRow(
                        title = stringResource(R.string.volume_1_day_usd),
                        value = "$${exchangeDetails.volume1DayUsd}"
                    )
                    InfoRow(
                        title = stringResource(R.string.volume_1mth_usd),
                        value = "$${exchangeDetails.volume1mthUsd}"
                    )
                    Divider(modifier = Modifier.padding(vertical = Dimens.dimen8dp))

                    InfoRow(
                        title = stringResource(R.string.rank),
                        value = exchangeDetails.rank,
                        icon = Icons.Default.Star
                    )
                }
            }
        }
    }
}
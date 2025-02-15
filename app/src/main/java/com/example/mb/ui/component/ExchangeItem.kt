package com.example.mb.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.mb.R
import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.ui.theme.Dimens

@Composable
fun ExchangeItem(exchange: ExchangeDataEntity, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(Dimens.SmallPadding)
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(Dimens.MediumPadding)) {
            Text(text = exchange.name, style = MaterialTheme.typography.headlineSmall)
            Text(text = stringResource(R.string.id, exchange.exchangeId))
            Text(text = stringResource(R.string.volume_1_day_usd, exchange.volume1DayUsd))
        }
    }
}
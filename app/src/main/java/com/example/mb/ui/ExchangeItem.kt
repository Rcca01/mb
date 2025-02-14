package com.example.mb.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mb.data.model.ExchangeDataEntity


@Composable
fun ExchangeItem(exchange: ExchangeDataEntity) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = exchange.name, style = MaterialTheme.typography.headlineSmall)
            Text(text = "ID: ${exchange.exchangeId}")
            Text(text = "Volume 1 day USD: ${exchange.volume1DayUsd}")
        }
    }
}
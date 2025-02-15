package com.example.mb.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.mb.R
import com.example.mb.data.model.ExchangeDataEntity
import com.example.mb.ui.ExchangeItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeListScreen (
    navController: NavController,
    exchanges: List<ExchangeDataEntity> = emptyList()
) {
    Scaffold(
    topBar = {
        TopAppBar(title = { Text(stringResource(R.string.lista_de_exchanges)) })
    }
    ) { padding ->
        LazyColumn(modifier = androidx.compose.ui.Modifier.padding(padding)) {
           items(exchanges) {
               ExchangeItem(exchange = it) {
                   navController.navigate("exchangeDetail/${it.exchangeId}")
               }
           }
        }
    }
}
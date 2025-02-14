package com.example.mb.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.mb.R
import com.example.mb.ui.component.Loading
import com.example.mb.viewmodel.ExchangeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeScreen(
    navController: NavController,
    viewModel: ExchangeViewModel = hiltViewModel()
) {
    val exchanges by viewModel.listExchanges.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchExchanges()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(stringResource(R.string.lista_de_exchanges)) })
        }
    ) { padding ->
        if (exchanges.isEmpty()) {
            Loading()
        } else {
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(exchanges) {
                    ExchangeItem(exchange = it) {
                        navController.navigate("exchangeDetail/${it.exchangeId}")
                    }
                }
            }
        }
    }
}

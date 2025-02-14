package com.example.mb.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.mb.viewmodel.ExchangeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExchangeScreen(viewModel: ExchangeViewModel = viewModel()) {
    val exchanges by viewModel.listExchanges.observeAsState(emptyList())

    LaunchedEffect(Unit) {
        viewModel.fetchExchanges()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Lista de Exchanges") })
        }
    ) { padding ->
        if (exchanges.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LazyColumn(modifier = Modifier.padding(padding)) {
                items(exchanges) {
                    ExchangeItem(exchange = it)
                }
            }
        }
    }
}

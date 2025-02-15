package com.example.mb.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun Loading() {
    Box(
        modifier = Modifier.fillMaxSize()
            .testTag("loading"),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}
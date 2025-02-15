package com.example.mb.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.mb.R
import com.example.mb.ui.theme.Dimens

@Composable
fun ErrorScreen(onRetry: () -> Unit, errorMessage: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Dimens.MediumPadding)
            .testTag("error_screen"),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = errorMessage,
            color = Color.Red,
            fontSize = Dimens.MediumText,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Dimens.MediumPadding))

        Button(onClick = onRetry) {
            Text(text = stringResource(R.string.tentar_novamente))
        }
    }
}
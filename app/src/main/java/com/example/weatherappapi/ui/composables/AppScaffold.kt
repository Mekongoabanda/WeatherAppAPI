package com.example.weatherappapi.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherappapi.ui.theme.WeatherAppAPITheme

@Composable
fun AppScaffold(){
    Scaffold(
        topBar = { AppBar() },
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.safeDrawing,
        content = { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
            ) {
                AppContent(modifier = Modifier.fillMaxSize())
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun AppScaffoldPreview() {
    WeatherAppAPITheme {
        AppScaffold()
    }
}
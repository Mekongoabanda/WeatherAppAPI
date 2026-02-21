package com.example.weatherappapi.ui.composables

import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(){
    TopAppBar(title = {
        Text(text = "My Weather App",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.SemiBold)
    })
}

@Preview(showBackground = true)
@Composable
fun AppBarPreview(){
    AppBar()
}
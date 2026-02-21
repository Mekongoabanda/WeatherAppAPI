package com.example.weatherappapi.ui.composables

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherappapi.R
import com.example.weatherappapi.ui.theme.WeatherAppAPITheme
import com.example.weatherappapi.ui.uistate.WeatherUIState
import com.example.weatherappapi.`view-model`.WeatherViewModel

@Composable
fun AppContent(modifier: Modifier, vm: WeatherViewModel = viewModel()){
    val manager = LocalFocusManager.current
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = vm.city,
            onValueChange = {vm.updateTextFieldsValue(it)},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = {
                vm.launchAPI()
                manager.clearFocus()
            }),
            singleLine = true,
            textStyle = MaterialTheme.typography.bodyLarge,
            label = {
                Text(stringResource(R.string.search_for_a_city),)
            },
            placeholder = {
                Text(stringResource(R.string.search_for_a_city),)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            trailingIcon = {
                IconButton(onClick = {vm.launchAPI()}) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Send,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        )
        when(vm.weatherState){
            is WeatherUIState.LOADING -> Text(text = stringResource(R.string.loading))
            is WeatherUIState.ERROR -> Text(text = stringResource(R.string.error))
            is WeatherUIState.SUCCESS -> Text(text = (vm.weatherState as WeatherUIState.SUCCESS).forecast.toString())
            else -> {Text("NOTHING.....")}
        }

    }
}

@Preview(showBackground = true)
@Composable
fun AppContentPreview() {
    WeatherAppAPITheme {
        AppContent(modifier = Modifier)
    }
}
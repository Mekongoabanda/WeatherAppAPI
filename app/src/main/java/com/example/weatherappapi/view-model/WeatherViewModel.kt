package com.example.weatherappapi.`view-model`

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappapi.`data-service`.WeatherApi
import com.example.weatherappapi.model.APIResults
import com.example.weatherappapi.ui.uistate.WeatherUIState
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

class WeatherViewModel : ViewModel() {
    // State of textfield
    var city: String by mutableStateOf("")

    // State of API call
    var weatherState: WeatherUIState by mutableStateOf(WeatherUIState.LOADING)

    fun updateTextFieldsValue(text: String) {
        city = text
    }

    fun launchAPI() {
        // Launch coroutine with WeatherService
        viewModelScope.launch {
            weatherState = try {
                val trimmedCity = city.trim()
                if (trimmedCity.isBlank()) {
                    WeatherUIState.ERROR
                } else {
                    // apiKey & lang ont des valeurs par défaut dans WeatherService
                    val result = WeatherApi.service.getForecast(city = trimmedCity)
                    WeatherUIState.SUCCESS(forecast = convertDatas(result))
                }
            } catch (_: IOException) {
                WeatherUIState.ERROR
            } catch (http: HttpException) {
                // Exemple: 401 si la clé est invalide, 404 si la ville est inconnue, etc.
                println("HTTP ${http.code()}: ${http.message()}")
                WeatherUIState.ERROR
            } catch (e: Exception) {
                // JSON invalide, NullPointer, etc.
                println(e.message)
                WeatherUIState.ERROR
            }
        }
    }

    private fun convertDatas(json: String): APIResults {
        return Gson().fromJson(json, APIResults::class.java)
    }
}
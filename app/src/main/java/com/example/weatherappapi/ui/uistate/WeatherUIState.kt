package com.example.weatherappapi.ui.uistate

import com.example.weatherappapi.model.APIResults

interface WeatherUIState {

    object LOADING: WeatherUIState
    object ERROR: WeatherUIState
    data class SUCCESS(val forecast: APIResults): WeatherUIState
}
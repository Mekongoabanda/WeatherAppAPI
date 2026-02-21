package com.example.weatherappapi.model

data class APIResults(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<Forecast>
)

data class Forecast(
    val dt: Long?,
    val main: MainInfo?,
    val weather: List<WeatherDescription>?,
    val clouds: Clouds?,
    val wind: Wind?,
    val visibility: Int?,
    val pop: Double?,
    val sys: SysInfo?,
    val dt_txt: String?
)

data class MainInfo(
    val temp: Double?,
    val feels_like: Double?,
    val temp_min: Double?,
    val temp_max: Double?,
    val pressure: Int?,
    val sea_level: Int?,
    val grnd_level: Int?,
    val humidity: Int?,
    val temp_kf: Double?
)

data class WeatherDescription(
    val id: Int?,
    val main: String?,
    val description: String?,
    val icon: String?
)

data class Clouds(
    val all: Int?
)

data class Wind(
    val speed: Double?,
    val deg: Int?,
    val gust: Double?
)

data class SysInfo(
    val pod: String?
)

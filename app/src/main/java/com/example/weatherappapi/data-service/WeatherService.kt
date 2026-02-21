package com.example.weatherappapi.`data-service`

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val BASE_URL = "https://api.openweathermap.org/data/2.5/"
private var scalarsConverterFactory = ScalarsConverterFactory.create()
//build retrofit
private val retrofit = Retrofit.Builder()
    .addConverterFactory(scalarsConverterFactory)
    .baseUrl(BASE_URL)
    .build()

//Call interface
interface WeatherService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("appid") apiKey: String = MY_KEY,
        @Query("lang") lang: String = "fr" ): String
}

object WeatherApi{
    val service: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }
}
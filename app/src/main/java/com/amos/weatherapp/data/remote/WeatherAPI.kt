package com.amos.weatherapp.data.remote

import retrofit2.http.Query

interface WeatherAPI {
    suspend fun getWeatherData(
        @Query("latitude") lat:Double
    )
}
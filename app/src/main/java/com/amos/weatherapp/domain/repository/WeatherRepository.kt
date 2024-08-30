package com.amos.weatherapp.domain.repository

import com.amos.weatherapp.domain.util.Resource
import com.amos.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}
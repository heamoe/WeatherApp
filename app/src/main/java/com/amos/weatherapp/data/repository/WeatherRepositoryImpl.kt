package com.amos.weatherapp.data.repository

import com.amos.weatherapp.data.mapper.toWeatherInfo
import com.amos.weatherapp.data.remote.WeatherAPI
import com.amos.weatherapp.domain.repository.WeatherRepository
import com.amos.weatherapp.domain.util.Resource
import com.amos.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherAPI
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = api.getWeatherData(
                    lat = lat,
                    long = long
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
    }
}
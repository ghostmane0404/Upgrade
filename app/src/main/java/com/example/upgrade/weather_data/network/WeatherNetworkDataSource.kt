package com.example.upgrade.weather_data.network

import androidx.lifecycle.LiveData
import com.example.upgrade.weather_data.response.CurrentWeatherEntry

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather:LiveData<CurrentWeatherEntry>
    suspend fun  fetchCurrentWeather(
        location:String,
        languageCode:String
    )
}
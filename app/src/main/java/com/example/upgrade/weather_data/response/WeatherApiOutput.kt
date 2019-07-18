package com.example.upgrade.weather_data.response

import com.google.gson.annotations.SerializedName


data class WeatherApiOutput(
    @SerializedName("current")
    val current: CurrentWeatherEntry,
    val location: Location
)
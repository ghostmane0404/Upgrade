package com.example.upgrade.weather_data.network

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.upgrade.weather_data.ApixuWeatherApi
import com.example.upgrade.weather_data.response.CurrentWeatherEntry

class WeatherNetworkDataSourceImpl(private val apixuWeatherApi: ApixuWeatherApi):WeatherNetworkDataSource {
    override val downloadedCurrentWeather: LiveData<CurrentWeatherEntry>
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override suspend fun fetchCurrentWeather(location: String, languageCode: String) {
        try {
            val fetchCurrentWeather = apixuWeatherApi
                .getCurrentWeather(location,languageCode)
                .await()
        }
        catch( e :Exception ){
            Log.d("ERROR","cant connect to internet")
        }
    }
}
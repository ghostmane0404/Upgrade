package com.example.upgrade.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.upgrade.weather_data.response.CurrentWeatherEntry

interface WeatherDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("Select * from current_weather where id = 0 ")
    fun getWeatherMetric():LiveData<CurrentWeatherEntry>
}
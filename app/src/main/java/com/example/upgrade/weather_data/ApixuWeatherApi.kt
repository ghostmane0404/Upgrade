package com.example.upgrade.weather_data

import com.example.upgrade.weather_data.network.ConnectivityInterceptor
import com.example.upgrade.weather_data.network.ConnectivityInterceptorImpl
import com.example.upgrade.weather_data.response.WeatherApiOutput
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val Api_Key = "7ca0cf444c754a7a84893522192706"

interface ApixuWeatherApi {
    @GET("current.json")
    suspend fun getCurrentWeather
                (@Query("q")city:String,@Query("lang")language:String = "en"):
             Deferred<Response<WeatherApiOutput>>

    companion object{
        operator  fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ):ApixuWeatherApi{
            val requestInterceptor = Interceptor {
                chain->
                val url  = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", Api_Key)
                    .build()
                val request  =chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)
            }
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.apixu.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApi::class.java)
        }
    }
}
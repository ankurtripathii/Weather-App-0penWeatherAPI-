package com.example.spiderwebtechtask.api
import com.example.spiderwebtechtask.model.current.WeatherModel
import com.example.spiderwebtechtask.model.forecast.WeatherParentModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherAPI {
    @GET("weather")
    fun getWeatherData(
        @Query("q")cityName:String,
        @Query("APPID")api_key:String
    ): Call<WeatherModel>

    @GET("weather")
    fun getCurrentWeatherData(
        @Query("lat")latitude: String,
        @Query("lon")longitude: String,
        @Query("APPID")api_key:String
    ): Call<WeatherModel>

    @GET("forecast")
    fun getForecastWeatherData(
        @Query("q")cityName:String,
        @Query("APPID")api_key:String,
    ): Call<WeatherParentModel>

    @GET("forecast")
    fun getCurrentForecastWeatherData(
        @Query("lat")latitude: String,
        @Query("lon")longitude: String,
        @Query("APPID")api_key:String,
    ): Call<WeatherParentModel>
}
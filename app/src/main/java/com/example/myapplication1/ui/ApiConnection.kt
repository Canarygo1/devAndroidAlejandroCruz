package com.example.myapplication1.ui

import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.*

class ApiConnection {
    @GET("location/search/")
    suspend fun getMovie(@Query("query") term: String): Response<List<City>>

    @GET("/api/location/{id}/")
    suspend fun getMovie(@Path("id") cityId: Int?): Response<WeatherResponse>
}


object RetrofitFactory {
    const val BASE_URL = "https://developers.themoviedb.org/3"

    fun getMovie(): ApiConnection {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(ApiConnection::class.java)
    }
}
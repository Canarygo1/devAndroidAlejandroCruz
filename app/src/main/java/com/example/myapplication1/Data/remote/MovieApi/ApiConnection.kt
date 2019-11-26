package com.example.myapplication1.Data.remote.MovieApi

import com.example.myapplication1.model.MovieDetail
import com.example.myapplication1.model.MovieResult

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.Response
import retrofit2.http.*


interface ApiConnection {
    @GET("search/movie?")
    suspend fun getMovie(@Query("api_key") apikeys: String, @Query("query") movie: String): Response<MovieResult>

    @GET("movie/{id}")
    suspend fun getDetailMovie(@Path("id") apiId: String, @Query("api_key") apikeys: String): Response<MovieDetail>
}

object RetrofitFactory {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    fun getMovieApi(): ApiConnection {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build().create(ApiConnection::class.java)
    }
}
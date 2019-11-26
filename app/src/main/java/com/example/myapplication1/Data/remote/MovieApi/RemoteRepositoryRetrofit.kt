package com.example.myapplication1.Data.remote.MovieApi

import android.accounts.NetworkErrorException
import com.example.myapplication1.model.MovieDetail
import com.example.myapplication1.model.MovieResult

class RemoteRepositoryRetrofit(val ApiConnection: ApiConnection) :
    RemoteRepository {
    val API_KEY = "b70643e31e5a9f73463e7b12408a53bb"
    override suspend fun searchMovie(term: String): MovieResult {
        val response = ApiConnection.getMovie(API_KEY, term)
        if (response.isSuccessful) {
            return response.body()!!
        } else {
            throw NetworkErrorException()
        }
    }

    override suspend fun movieDetails(term: String): MovieDetail {
        val response = ApiConnection.getDetailMovie(term, API_KEY)
        return response.body()!!
    }
}
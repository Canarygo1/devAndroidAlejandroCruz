package com.example.myapplication1.Data

import com.example.myapplication1.model.MovieDetail
import com.example.myapplication1.model.MovieResult

interface RemoteRepository {
    suspend fun searchMovie(term:String):MovieResult
    suspend fun movieDetails(term:String):MovieDetail
}
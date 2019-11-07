package com.example.myapplication1.ui

import com.example.myapplication1.model.Movie
import com.example.myapplication1.model.MovieDetail
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter (val view: MovieDetailView){
    val apiKey = "b70643e31e5a9f73463e7b12408a53bb"
    fun fetchCityDetail(movieId: Int) {
        val apiConnection = RetrofitFactory.getMovie()
        CoroutineScope(Dispatchers.IO).launch {
            val response = apiConnection.getDetailMovie(movieId.toString(),apiKey)
            println("Los resultados"+response)
            withContext(Dispatchers.Main) {

                view.showMovieDetail(response)
            }
        }
    }
}

interface MovieDetailView {
    fun showMovieDetail(detail:MovieDetail)
}

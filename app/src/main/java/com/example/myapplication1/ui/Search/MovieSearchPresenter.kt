package com.example.myapplication1.ui.Search

import com.example.myapplication1.Data.remote.MovieApi.RemoteRepository
import com.example.myapplication1.model.Movie
import com.example.myapplication1.model.MovieResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MovieSearchPresenter(val view: searchFragment, val remoteRespository: RemoteRepository) {

    fun searchClicked(searchTerm: String) {
        if (searchTerm.isEmpty()) return
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = remoteRespository.searchMovie(searchTerm)
                withContext(Dispatchers.Main) {
                    view.showMovie(response)
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    println(e)
                }
            }
        }
    }

    fun MovieClicked(movie: Movie) {
        view.openMovieDetail(movie)
    }
}

interface MovieSearch {
    fun showMovie(movies: MovieResult)
    fun openMovieDetail(id: Movie)
}
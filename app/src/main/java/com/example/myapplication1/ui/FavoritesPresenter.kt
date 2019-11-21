package com.example.myapplication1.ui

import com.example.myapplication1.Data.local.MovieDataBase
import com.example.myapplication1.Data.local.MovieEntity
import com.example.myapplication1.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FavoritesPresenter(val view: favoritesFragment) {
    val db = MovieDataBase(view.context!!)

    fun searchClicked(searchTerm: String) {
        if (searchTerm.isEmpty()) return
        CoroutineScope(Dispatchers.IO).launch {
            var data: MovieEntity? = db.MovieDao().findByTitle(searchTerm)
            withContext(Dispatchers.Main) {
                print(data)
                if (data != null) {
                    view.showMovies(listOf(data))
                } else {
                    view.showMoviesNull()
                }
            }
        }
    }

    fun loadAllMovies() {
        CoroutineScope(Dispatchers.IO).launch {
            var data = db.MovieDao().getAll()
            withContext(Dispatchers.Main) {
                view.showMovies(data)
            }
        }
    }

    fun deleteAll() {
        CoroutineScope(Dispatchers.IO).launch {
            db.MovieDao().deleteAll()
            withContext(Dispatchers.Main) {
                var data = listOf<MovieEntity>()
                view.showMovies(data)
            }
        }
    }

    fun movieClicked(movie: Movie) {
        print("Proxima implementacion...En construccion")
    }
}

interface MovieFovoritesSearch {
    fun showMovies(allFavoritesmovies: List<MovieEntity>)
}
package com.example.myapplication1.ui.details

import com.example.myapplication1.Data.RemoteRepository
import com.example.myapplication1.Data.local.MovieDataBase
import com.example.myapplication1.Data.local.MovieEntity
import com.example.myapplication1.model.Movie
import com.example.myapplication1.model.MovieDetail
import com.example.myapplication1.ui.details.MovieActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieDetailPresenter(
    val view: MovieActivity,
    private val remoteRepository: RemoteRepository
) {
    var db: MovieDataBase = MovieDataBase(view)
    fun fetchMovieDetail(movieId: Int) {
        CoroutineScope(Dispatchers.IO).launch {
            val response = remoteRepository.movieDetails(movieId.toString())
            withContext(Dispatchers.Main) {
                view.showMovieDetail(response)
            }
        }
    }

    fun fetchMovieDetailToDB(movie: Movie) {
        CoroutineScope(Dispatchers.IO).launch {
            var movieEntity = MovieEntity(
                movie.title,
                movie.original_title,
                movie.vote_average.toString(),
                movie.release_date,
                movie.poster_path
            )
            db.MovieDao().insertAll(movieEntity)
            withContext(Dispatchers.Main) {

            }
        }
    }

    fun movieExist(termSearch: String) {
        CoroutineScope(Dispatchers.IO).launch {
            var data: MovieEntity? = db.MovieDao().findByTitle(termSearch)
            withContext(Dispatchers.Main) {
                print(data)
                if (data != null) {
                    view.isInFavorites()
                } else {
                    view.noInFavorites()
                }
            }

        }

    }

    fun deleteOne(termSearch: String) {
        CoroutineScope(Dispatchers.IO).launch {
            db.MovieDao().deleteOne(termSearch)
            withContext(Dispatchers.Main) {

            }
        }
    }
}

interface MovieDetailView {
    fun showMovieDetail(detail: MovieDetail)
    fun isInFavorites()
    fun noInFavorites()
}
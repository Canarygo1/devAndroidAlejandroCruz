package com.example.myapplication1.ui.details

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication1.Data.remote.MovieApi.RemoteRepository
import com.example.myapplication1.Data.remote.MovieApi.RemoteRepositoryRetrofit
import com.example.myapplication1.Data.remote.MovieApi.RetrofitFactory


import com.example.myapplication1.R
import com.example.myapplication1.model.Movie

import com.example.myapplication1.model.MovieDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie.*


class MovieActivity : AppCompatActivity(), MovieDetailView {
    lateinit var presenter: MovieDetailPresenter
    lateinit var movie: Movie
    var favIconConditional: Boolean = false
    lateinit var favIconButton: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        val remoteRepository: RemoteRepository =
            RemoteRepositoryRetrofit(RetrofitFactory.getMovieApi())
        movie = intent.extras?.getSerializable("movie") as Movie
        presenter =
            MovieDetailPresenter(this, remoteRepository)
        presenter.fetchMovieDetail(movie.id)
    }

    override fun showMovieDetail(detail: MovieDetail) {
        val title = movieTittle
        val yearTittle = yearTxt
        val descriptionTxt = descriptionTxt
        val backdrop = backdrop
        favIconButton = favIcon
        title.text = detail.original_title
        yearTittle.text = detail.release_date
        descriptionTxt.text = detail.overview
        genreTxt.text = detail.genres.get(0).name

        Picasso.get().load("https://image.tmdb.org/t/p/w500${detail.backdrop_path}").into(backdrop)
//        favIconButton.setImageResource(R.drawable.baseline_favorite_border_black_18dp)
        presenter.movieExist(movie.title)

        favIconButton.setOnClickListener {
            if (favIconConditional == false) {
                presenter.fetchMovieDetailToDB(movie)
                presenter.movieExist(movie.title)
            } else {
                presenter.deleteOne(movie.title)
                presenter.movieExist(movie.title)
            }
        }
    }

    override fun isInFavorites() {

        favIconButton.setImageResource(R.drawable.baseline_favorite_black_18dp)
        favIconConditional = true

    }

    override fun noInFavorites() {
        favIconButton.setImageResource(R.drawable.baseline_favorite_border_black_18dp)
        favIconConditional = false
    }


}
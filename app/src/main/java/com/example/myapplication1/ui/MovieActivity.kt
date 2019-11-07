package com.example.myapplication1.ui

//themoviedb.org api
//Crear modelos objectos del Json
//
//
//
//
//
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.myapplication1.R
import com.example.myapplication1.model.Movie
import com.example.myapplication1.model.MovieDetail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie.*


class MovieActivity : AppCompatActivity(),MovieDetailView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        val cityId = intent.extras?.getInt("id")
        val presenter = MovieDetailPresenter(this)
        presenter.fetchCityDetail(cityId!!)
    }

    override fun showMovieDetail(detail:MovieDetail) {

        val title = movieTittle
        val  yearTittle = yearTxt
        val  descriptionTxt = descriptionTxt
        val backdrop = backdrop
        title.text = detail.original_title
        yearTittle.text = detail.release_date
        descriptionTxt.text = detail.overview
        genreTxt.text = detail.genres.get(0).name
        Picasso.get().
            load("https://image.tmdb.org/t/p/w500${detail.backdrop_path}").
            into(backdrop)
    }
}

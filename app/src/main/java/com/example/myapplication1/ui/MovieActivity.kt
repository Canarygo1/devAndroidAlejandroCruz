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
import com.example.myapplication1.R
import com.example.myapplication1.model.Movie
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie.*
class MovieActivity : AppCompatActivity() {
    val movie = Movie(
        id = 1,
        tittle = "Macarena",
        year = "1996",
        genre = "Thriller",
        description ="asdadasddasdsdasdzsadasdsdsfsdasffsfasfsdfggdgffddffsdfsdfsfsdfsfsfsf",
        rating = 9.8
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)
        with(movie){
            movieTittle.text = tittle
            yearTittle.text = year
            genreTxt.text = genre
            descriptionTxt.text = description
            ratingTxt.text = rating.toString()
            Picasso.get()
                .load("https://files.merca20.com/uploads/2018/06/Stranger-Things-Netflix.jpg")
                .into(imageView)
        }

    }

    override fun onSaveInstanceState(outState: Bundle?) {

        super.onSaveInstanceState(outState)
    }

    override fun onResume() {
        Log.e("MovieActivity", "onresume")
        super.onResume()
    }

    override fun onStart() {
        Log.e("MovieActivity", "onStart")
        super.onStart()
    }

    override fun onDestroy() {
        Log.e("MovieActivity", "onDestroy")
        super.onDestroy()
    }

    override fun onStop() {
        Log.e("MovieActivity", "onStop")
//        onSaveInstanceState(savedInstanceState)
        super.onStop()
    }

    override fun onPause() {
        Log.e("MovieActivity", "onPause")
        super.onPause()
    }
}

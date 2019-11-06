package com.example.myapplication1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.myapplication1.R

import com.example.myapplication1.model.Movie
import kotlinx.android.synthetic.main.activity_movie_list.*
import kotlinx.android.synthetic.main.movie_row.*
class ActivityMovieList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
        setContentView(R.layout.activity_movie_list)
        my_recycler_view.layoutManager = LinearLayoutManager(this)
        my_recycler_view.adapter = MyAdapter(createMovies(),this)
    }
    fun createMovies() : ArrayList<Movie>{
        val firstMovie = Movie(R.drawable.steve_jobs,9,"Pepe","terror","1999"," hola pelicula",9.7)
        val secondMovie = Movie(R.drawable.steve_jobs,9,"josle","terror","1999","Hola pelicula",9.7)
        val thirdMovie = Movie(R.drawable.steve_jobs,9,"se fuer","terror","1999","Hola pelicula",9.7)
        val fourthMovie = Movie(R.drawable.steve_jobs,9,"Pepe","terror","1999","Hola pelicula",9.7)
        val list: ArrayList<Movie> = ArrayList()
        list.add(firstMovie)
        list.add(secondMovie)
        list.add(thirdMovie)
        list.add(fourthMovie)
        return list
    }
}
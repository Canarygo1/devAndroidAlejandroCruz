package com.example.myapplication1.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.example.myapplication1.R

import com.example.myapplication1.model.Movie
import kotlinx.android.synthetic.main.activity_movie_list.*

class ActivityMovieList : AppCompatActivity() , CitySearchView{


    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val presenter = MovieSearchPresenter(this)

        my_recycler_view.layoutManager = LinearLayoutManager(this)
//        my_recycler_view.adapter = MovieAdapter(this)
        searchBtn.setOnClickListener {
            val searchTerm = queryTxt.text.toString()
            presenter.searchClicked(searchTerm)
        }
        movieAdapter = MovieAdapter {
            presenter.cityClicked(it)
        }
        my_recycler_view.adapter = movieAdapter
    }
    override fun showCities(movies: List<Movie>) {
        movieAdapter.addCities(movies)
        my_recycler_view.visibility = View.VISIBLE
//        emptyView.visibility = View.GONE
    }

    override fun openCityDetail(id: Int) {
        val intent = Intent(this, MovieActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

    override fun showError() {
        Toast.makeText(this, "Error fetching cities", Toast.LENGTH_SHORT).show()
    }

    override fun showEmpty() {
//        emptyView.visibility = View.VISIBLE
//        citiesRecyclerView.visibility = View.GONE
    }
}
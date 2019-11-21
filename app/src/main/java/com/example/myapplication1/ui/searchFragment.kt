package com.example.myapplication1.ui


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.myapplication1.Data.RemoteRepository
import com.example.myapplication1.Data.RemoteRepositoryRetrofit
import com.example.myapplication1.Data.RetrofitFactory
import com.example.myapplication1.R
import com.example.myapplication1.model.Movie

import com.example.myapplication1.model.MovieResult
import kotlinx.android.synthetic.main.fragment_search.*

class searchFragment : Fragment() ,MovieSearch{
    lateinit var button:Button
    lateinit var text:EditText
    lateinit var presenter: MovieSearchPresenter
    lateinit var movieAdapter: MovieAdapter

    override fun showMovie(movies: MovieResult) {
        movieAdapter.addMovies(movies.results)
    }

    override fun openMovieDetail(movie: Movie) {
        val intent = Intent(this.context, MovieActivity::class.java)
        intent.putExtra("movie", movie)
        startActivity(intent)
   }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val remoteRepository: RemoteRepository = RemoteRepositoryRetrofit(RetrofitFactory.getMovieApi())
        presenter = MovieSearchPresenter(this,remoteRepository)
        button = view.findViewById(R.id.buttonFavorites)
        text = view.findViewById(R.id.editTextFavorites)

        list_recycler_view.apply {
            layoutManager = LinearLayoutManager(this.context)
            movieAdapter = MovieAdapter {
                presenter.MovieClicked(it)
            }
            adapter = movieAdapter
        }
        button.setOnClickListener{
            presenter.searchClicked(text.text.toString())
        }
    }
}
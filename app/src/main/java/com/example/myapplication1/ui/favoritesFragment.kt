package com.example.myapplication1.ui


import android.os.Bundle
import android.view.*
import android.widget.Toast

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication1.Data.local.MovieEntity
import com.example.myapplication1.R
import com.example.myapplication1.model.Movie
import kotlinx.android.synthetic.main.fragment_favorites.*

class favoritesFragment : Fragment(), MovieFovoritesSearch {
    lateinit var movieAdapter: MovieAdapter
    lateinit var presenter: FavoritesPresenter

    override fun showMovies(allFavoritesmovies: List<MovieEntity>) {
        var movieList: MutableList<Movie> = mutableListOf()
        println(allFavoritesmovies.get(0).originalTitle)



        allFavoritesmovies.forEach {
            var movie = Movie(
                0,
                it.poster,
                it.title,
                it.originalTitle,
                it.releaseDate,
                it.rating.toDouble()
            )
            movieList.add(movie)
            movieAdapter.addMovies(movieList)
        }
    }

    fun showMoviesNull() {
        Toast.makeText(this.context, "Dato no encontrado pruebe con otros", Toast.LENGTH_SHORT)
            .show()
        presenter.loadAllMovies()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        presenter = FavoritesPresenter(this)
        list_recycler_view_favorites.apply {
            layoutManager = LinearLayoutManager(this.context)
            movieAdapter = MovieAdapter { presenter.movieClicked(it) }
            adapter = movieAdapter
        }
        presenter.loadAllMovies()
        buttonFavorites.setOnClickListener {
            presenter.searchClicked(editTextFavorites.text.toString())
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.deleteAll -> {
                presenter.deleteAll()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.favoritesmenu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}

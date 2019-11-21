package com.example.myapplication1.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication1.R
import com.example.myapplication1.model.Movie
import com.squareup.picasso.Picasso



class MovieAdapter(private val listener: (Movie) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    private var movieList = listOf<Movie>()

    fun addMovies(newMovie: List<Movie>) {
        this.movieList = newMovie
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int {
        return movieList.size
    }
    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(p0)
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.bind(movieList[p1], listener)
    }
}
class ViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view) {
    private val title = view.findViewById<TextView>(R.id.title)
    private val original_title = view.findViewById<TextView>(R.id.original_title)
    private val releaseDate = view.findViewById<TextView>(R.id.releaseDateTxt)
    private val rating = view.findViewById<TextView>(R.id.rating)
    private val poster = view.findViewById<ImageView>(R.id.poster)


    fun bind(movie: Movie, listener: (Movie) -> Unit) {
        title.text = movie.title
        original_title.text = movie.original_title
        releaseDate.text = movie.release_date
        rating.text = movie.vote_average.toString()
        Picasso.get().
            load("https://image.tmdb.org/t/p/w500${movie.poster_path}").
            into(poster)
        this.itemView.setOnClickListener { listener.invoke(movie) }
    }
    companion object {
        fun from(parent: ViewGroup): ViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_row, parent, false)
            return ViewHolder(view)
        }
    }
}
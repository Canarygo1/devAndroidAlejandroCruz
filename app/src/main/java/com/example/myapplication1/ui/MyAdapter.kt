package com.example.myapplication1.ui

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication1.R
import com.example.myapplication1.model.Movie
import kotlinx.android.synthetic.main.activity_second.view.*
import kotlinx.android.synthetic.main.movie_row.view.*

class MyAdapter(val movieList : ArrayList<Movie>, val context:Context) : RecyclerView.Adapter<ViewHolder>() {




    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.movie_row, p0, false))
    }
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.title?.text = movieList.get(p1).tittle
        p0.originalTitle?.text = movieList.get(p1).tittle
        p0.releaseDate?.text = movieList.get(p1).year
        p0.rating?.text = movieList.get(p1).rating.toString()
        p0.poster?.setImageResource(movieList.get(p1).poster)
    }
}
class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val title = view.title
    val originalTitle = view.original_title
    val releaseDate = view.releaseDateTxt
    val rating = view.rating
    val poster = view.poster

}



package com.example.myapplication1.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.example.myapplication1.R
import kotlinx.android.synthetic.main.activity_movie_list.*

class ActivityMovieList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)
            setContentView(R.layout.activity_movie_list)
            my_recycler_view.layoutManager = LinearLayoutManager(this)
            my_recycler_view.adapter = MyAdapter()
        }
    }



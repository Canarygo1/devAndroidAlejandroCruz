package com.example.myapplication1.model

import android.media.Image
import android.widget.ImageView
import com.example.myapplication1.R

data class Movie(
    val poster:Int,
    val id: Int,
    val tittle: String,
    val genre: String,
    val year: String,
    val description: String,
    val rating: Double
)
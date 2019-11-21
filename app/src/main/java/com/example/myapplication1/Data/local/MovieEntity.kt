package com.example.myapplication1.Data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movie_items")
data class MovieEntity(
    @PrimaryKey var title: String,
    @ColumnInfo(name = "originalTitle") var originalTitle: String,
    @ColumnInfo(name ="rating") var rating: String,
    @ColumnInfo(name ="releaseDate") var releaseDate: String,
    @ColumnInfo(name ="poster") var poster: String
)
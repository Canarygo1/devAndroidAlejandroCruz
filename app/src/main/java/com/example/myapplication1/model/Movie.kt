package com.example.myapplication1.model



data class Movie(
    val id:Int,
    val poster_path:String,
    val title: String,
    val original_title:String,
    val release_date: String,
    val vote_average: Double,
    val backdrop_path:String,
    val overview:String,
    val name:String,
    val genres:List<String>,
    val quetal:String,
    val genre_ids:List<Int>
)
data class MovieResult(
    var page: Int,
    var total_page:Int,
    var results:MutableList<Movie>
)
data class MovieDetail(
    val name:String,
    var genres: List<genre>,
    val title: String,
    val original_title:String,
    val overview:String,
    val release_date: String,
    val backdrop_path:String
)
data class genre(
    val id: Int,
    val name:String
)
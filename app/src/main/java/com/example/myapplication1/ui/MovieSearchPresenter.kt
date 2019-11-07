package com.example.myapplication1.ui
import com.example.myapplication1.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MovieSearchPresenter(val view: ActivityMovieList) {

    fun searchClicked(searchTerm: String) {
        if (searchTerm.isEmpty()) return

        val movieApi = RetrofitFactory.getMovie()
        val apiKey = "b70643e31e5a9f73463e7b12408a53bb"
        CoroutineScope(Dispatchers.IO).launch {

            val response = movieApi.getMovie(apiKey,searchTerm)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    val movies = response.body()!!.results
                    if (movies.isEmpty()) {
                        view.showEmpty()
                        return@withContext
                    }
                    view.showCities(response.body()!!.results)
                } else {
                    view.showError()
                }
            }
        }
    }

    fun cityClicked(movie: Movie) {
        println(movie.id)
        view.openCityDetail(movie.id)
    }
}
interface CitySearchView {
    fun showCities(cities: List<Movie>)
    fun openCityDetail(woeid: Int)
    fun showError()
    fun showEmpty()
}
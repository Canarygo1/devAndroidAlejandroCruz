package com.example.myapplication1.Data.local

import androidx.room.*
import com.example.myapplication1.model.Movie

@Dao
interface MovieDao {
    @Query("SELECT * FROM movie_items")
    fun getAll(): List<MovieEntity>

    @Query("SELECT * FROM movie_items WHERE title LIKE :title")
    fun findByTitle(title: String): MovieEntity

    @Insert
    fun insertAll(vararg movie: MovieEntity)

    @Delete
    fun delete(movie: MovieEntity)

    @Update
    fun updateTodo(vararg movie: MovieEntity)

    @Query("DELETE FROM movie_items")
    fun deleteAll()

    @Query("DELETE FROM movie_items WHERE title LIKE :title")
    fun deleteOne(title: String)
}
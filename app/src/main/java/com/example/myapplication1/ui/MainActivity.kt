package com.example.myapplication1.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.example.myapplication1.R

class MainActivity : AppCompatActivity() {
    private var counter = 0
    private val name: String = "Alejandro Cruz"
    private val city: String = "S/C de Tenerife"
    private val description: String =
        "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
    private val birthday: String = "02/06/1999"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val counterButton: Button = findViewById(R.id.myCounterButton)
        val button: Button = findViewById(R.id.myButton)
        val textCounter: TextView = findViewById(R.id.text)
        counterButton.setOnClickListener {
            counter++
            textCounter.text = counter.toString()
        }
        button.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra("name", name)
                putExtra("city", city)
                putExtra("description", description)
                putExtra("birthday", birthday)
            }
            startActivity(intent)
        }
        val buttonMovie: Button = findViewById(R.id.myButton2)
        buttonMovie.setOnClickListener {
            val intentMovie = Intent(this, MovieActivity::class.java).apply {

            }
            startActivity(intentMovie)
        }
        val buttonMovieList: Button = findViewById(R.id.myButton3)
        buttonMovieList.setOnClickListener {
            val intentMovieList = Intent(this, ActivityMovieList::class.java).apply {
            }
            startActivity(intentMovieList)
        }
    }
//onsaveInstanceState


    override fun onResume() {
        Log.e("MainActivity", "onresume")
        super.onResume()
    }

    override fun onStart() {
        Log.e("MainActivity", "onStart")
        super.onStart()
    }

    override fun onDestroy() {
        Log.e("MainActivity", "onDestroy")
        super.onDestroy()
    }

    override fun onStop() {
        Log.e("MainActivity", "onStop")
        super.onStop()
    }

    override fun onPause() {
        Log.e("MainActivity", "onPause")
        super.onPause()
    }
}
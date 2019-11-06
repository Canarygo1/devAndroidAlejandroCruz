package com.example.myapplication1.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.example.myapplication1.R

class SecondActivity : AppCompatActivity() {
    lateinit var nameText: TextView
    lateinit var descriptionText: TextView
    lateinit var cityText: TextView
    lateinit var birthdayText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val name: String = intent.getStringExtra("name")
        val description: String = intent.getStringExtra("description")
        val city: String = intent.getStringExtra("city")
        val birthday: String = intent.getStringExtra("birthday")

        setContentView(R.layout.activity_second)
        nameText = findViewById(R.id.name)
        descriptionText = findViewById(R.id.description)
        cityText = findViewById(R.id.city)
        birthdayText = findViewById(R.id.birthday)

        var imageView = findViewById<ImageView>(R.id.image)
        birthdayText.text = birthday
        imageView.setImageResource(R.drawable.personal)
        nameText.text = name
        descriptionText.text = description
        cityText.text = city
    }
}

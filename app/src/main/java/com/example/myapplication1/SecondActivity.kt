package com.example.myapplication1

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView

import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val name:String = intent.getStringExtra("name")
        val description:String = intent.getStringExtra("description")
        val city:String = intent.getStringExtra("city")
        val birthday:String = intent.getStringExtra("birthday")
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        val nameText : TextView = findViewById(R.id.name)
        val descriptionText : TextView = findViewById(R.id.description)
        val cityText : TextView = findViewById(R.id.city)
        val birthdayText : TextView = findViewById(R.id.birthday)

        var imageView = findViewById<ImageView>(R.id.image)
        birthdayText.text = birthday
        imageView.setImageResource(R.drawable.personal)
        nameText.text = name
        descriptionText.text = description
        cityText.text = city
    }
}

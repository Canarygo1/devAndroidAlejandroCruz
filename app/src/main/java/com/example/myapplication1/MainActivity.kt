package com.example.myapplication1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
<<<<<<< HEAD
    private val name:String = "Alejandro Cruz"
    private val city:String = "S/C de Tenerife"
    private val description:String = "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."

    override fun onCreate(savedInstanceState: Bundle?) {
=======
  override fun onCreate(savedInstanceState: Bundle?) {
>>>>>>> production
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main)

    val button:Button = findViewById(R.id.myButton)
    button.setOnClickListener {
        val intent = Intent(this, SecondActivity::class.java).apply {
<<<<<<< HEAD
            putExtra("name",  name) 
            putExtra("city", city)
            putExtra("description",description)

        }
=======

    }
>>>>>>> production
        startActivity(intent)
  }
 }
}
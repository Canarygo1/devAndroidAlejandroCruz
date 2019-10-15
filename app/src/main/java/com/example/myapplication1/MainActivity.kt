package com.example.myapplication1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main)

    val button:Button = findViewById(R.id.myButton)
    button.setOnClickListener {
        val intent = Intent(this, SecondActivity::class.java).apply {

    }
        startActivity(intent)
  }
 }
}
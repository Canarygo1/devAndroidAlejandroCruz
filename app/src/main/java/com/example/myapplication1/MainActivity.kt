package com.example.myapplication1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
var count = 0;
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main)

    val boton:Button = findViewById(R.id.myButton)
    boton.setOnClickListener {
      Toast.makeText(MainActivity@this, "${count++}", Toast.LENGTH_SHORT).show()
      val text: TextView = findViewById(R.id.texto)
      text.text = count.toString()
      
      boton.text = "Click again!"
    }
  }
}

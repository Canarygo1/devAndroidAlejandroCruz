package com.example.myapplication1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.myapplication1.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val navView:BottomNavigationView = findViewById(R.id.nav_view)
    val navController = findNavController(R.id.myNavHostFragment)
    val appBarConfiguration = AppBarConfiguration(
        setOf(
          R.id.searchFragment,R.id.favoritesFragment
        )
      )
      setupActionBarWithNavController(navController,appBarConfiguration)
      navView.setupWithNavController(navController)
  }
}
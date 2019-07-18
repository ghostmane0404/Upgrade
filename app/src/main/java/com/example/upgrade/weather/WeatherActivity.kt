package com.example.upgrade.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController

import kotlinx.android.synthetic.main.activity_weather.*
import android.R
import androidx.navigation.NavOptions




class WeatherActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.upgrade.R.layout.activity_weather)
        val toolbar: Toolbar = findViewById(com.example.upgrade.R.id.w_toolbar)
        setSupportActionBar(toolbar)

        navController = Navigation.findNavController(this, com.example.upgrade.R.id.nav_host_fragment)
        bottom_nav.setupWithNavController(navController)
        NavigationUI.setupActionBarWithNavController(this,navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(null,navController)
    }
}

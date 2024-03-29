package com.fiham.needyfood.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.fiham.needyfood.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottmNav)
//        val navController = Navigation.findNavController(this,R.id.fragment)

        val bottomNavogation = findViewById<BottomNavigationView>(R.id.bottmNav)
        val navController = Navigation.findNavController(this, R.id.fragment)

        NavigationUI.setupWithNavController(bottomNavogation,navController)




    }
}
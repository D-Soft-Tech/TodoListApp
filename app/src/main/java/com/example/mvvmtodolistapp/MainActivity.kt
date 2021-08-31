package com.example.mvvmtodolistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup action bar with the nav controller
        setupActionBarWithNavController(findNavController(R.id.navHost))
    }

    override fun onSupportNavigateUp(): Boolean {
        val navCon = findNavController(R.id.navHost)

        return navCon.navigateUp() || super.onSupportNavigateUp()
    }
}

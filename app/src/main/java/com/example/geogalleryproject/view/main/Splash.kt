package com.example.geogalleryproject.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.geogalleryproject.R

lateinit var handler: Handler

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler = Handler()
        handler.postDelayed({

            // Delay and Start Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } , 2000) // here we're delaying to startActivity after 3seconds
    }
    }


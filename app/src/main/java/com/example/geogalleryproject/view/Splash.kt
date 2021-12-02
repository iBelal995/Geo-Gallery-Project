package com.example.geogalleryproject.view


import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.example.geogalleryproject.R
import com.example.geogalleryproject.repositories.ApiServicesRepository
import com.example.geogalleryproject.repositories.RoomServiceRepository

lateinit var handler: Handler

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ApiServicesRepository.init(this)
        RoomServiceRepository.init(this)

        setContentView(R.layout.activity_splash)
        if (Build.VERSION.SDK_INT >= 21) {
            window.navigationBarColor =
                this.resources.getColor(R.color.white) // this is for the navigation bar color of the android system


        }
        handler = Handler()
        handler.postDelayed({
            // Delay and Start Activity
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        } , 2000) // here we're delaying to startActivity after 3seconds
    }
    }

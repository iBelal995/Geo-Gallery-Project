package com.example.geogalleryproject.view.main

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.geogalleryproject.R
import com.google.android.gms.location.LocationServices
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    // this line will be deleted
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        checkPermission()

        var fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)
        var getLocation = fusedLocationProviderClient.lastLocation

        getLocation.addOnSuccessListener {
            try{
                if(it != null){
                    var longitude = it.longitude
                    var latitude = it.latitude
                    Log.d(TAG,"Lat:$latitude Long:$longitude")
                }
            }catch (e:Exception){
                Log.d(TAG,e.message.toString())
            }
        }
    }

    //check user location permission
    fun checkPermission(){
        if(ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_DENIED
            || ContextCompat.checkSelfPermission(this,android.Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),0)
        }
    }

}
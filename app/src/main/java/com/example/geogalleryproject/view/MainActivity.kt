package com.example.geogalleryproject.view

import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.toColor
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.geogalleryproject.R
import com.example.geogalleryproject.databinding.ActivityMainBinding
import com.google.android.gms.location.LocationServices
import java.lang.Exception

class MainActivity : AppCompatActivity() {


    // this line will be deleted
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var navControllor: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            window.navigationBarColor =
                this.resources.getColor(R.color.white) // this is for the navigation bar color of the android system
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
    val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    navControllor = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.homeBottomNavigation,navControllor)
    setupActionBarWithNavController(navControllor)






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

    override fun onSupportNavigateUp(): Boolean {
        return navControllor.navigateUp()

    }

}
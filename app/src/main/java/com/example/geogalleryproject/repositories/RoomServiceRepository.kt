package com.example.geogalleryproject.repositories

import android.content.Context
import androidx.room.Room
import com.example.geogalleryproject.database.GeoGalleryDatabase
import com.example.geogalleryproject.model.Photo
import java.lang.Exception

private const val DATABASE_NAME = "Geo-Gallery-Database"
class RoomServiceRepository(context: Context) {

    private val database = Room.databaseBuilder(
        context, GeoGalleryDatabase::class.java, DATABASE_NAME)
        .fallbackToDestructiveMigration()
        .build()

    private val geoGalleryDao = database.geoGalleryDao()

//    suspend fun insertPhotos(photos:List<Photo>) = geoGalleryDao.insertPhotos(photos)
//    suspend fun getPhoto() = geoGalleryDao.getPhoto()

    companion object{

        private var instance: RoomServiceRepository? = null

        fun init(context: Context){
            if (instance == null)
                instance = RoomServiceRepository(context)
        }

        fun get(): RoomServiceRepository{
            return instance?: throw Exception("ApiServicesRepository must be initialized")
        }
    }
}
package com.example.geogalleryproject.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.geogalleryproject.model.GeoGalleryModel
import com.example.geogalleryproject.model.Photo


@Database(entities = [Photo::class], version = 2)
abstract class GeoGalleryDatabase : RoomDatabase() {

    abstract fun geoGalleryDao(): GeoGalleryDao
}
package com.example.geogalleryproject.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.geogalleryproject.model.Photo


@Dao
interface GeoGalleryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photos:List<Photo>)


    @Query("SELECT * FROM photo")
    suspend fun getPhoto():List<Photo>
}

package com.example.geogalleryproject.database

import androidx.room.*
import com.example.geogalleryproject.model.Photo
import retrofit2.http.GET


@Dao
interface GeoGalleryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhotos(photos:List<Photo>)


    @Query("SELECT * FROM photo")
    suspend fun getPhoto():List<Photo>

    @GET("SELECT * FROM photo WHERE isFavorite")
    suspend fun getFavorites():List<Photo>

    @Update
    suspend fun updateIsFavorite(photo: Photo)

}

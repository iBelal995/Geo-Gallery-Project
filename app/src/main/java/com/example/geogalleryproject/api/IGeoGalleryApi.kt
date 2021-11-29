package com.example.geogalleryproject.api

import com.example.geogalleryproject.model.photo.GeoGalleryModel
import com.example.geogalleryproject.model.photoinfo.PhotosInfo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IGeoGalleryApi {

    @GET("https://www.flickr.com/services/rest/?method=flickr.photos.search&api_key=62eca812a07060c763fa2650f884bd88&extras=url_m%2C+geo&format=json&nojsoncallback=1")
    suspend fun getImages(

        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("accuracy") accurancy: Int = 11
    ): Response<GeoGalleryModel>



    @GET("/services/rest//?method=flickr.photos.getInfo&api_key=15e52a7d6e2ba6b8a566c7748882115c&photo_id=51490281974&secret=d8276d4e3f881238&format=json&nojsoncallback=1")
    suspend fun getInfo(): Response<PhotosInfo>
}
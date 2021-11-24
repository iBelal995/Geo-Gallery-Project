package com.example.geogalleryproject.api

import com.example.geogalleryproject.model.Photo
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface IGeoGalleryApi {

    @GET("services/rest/?method=flickr.photos.search&api_key=7215a059699c7bdb07760b04582ee461&lat=26.3945889&lon=50.1954646&extras=url_m%2C+geo&format=json&nojsoncallback=1&auth_token=72157720823573219-11823d3a0e0e0637&api_sig=b9c3bc7d343c68891d19f76a8a6e88a6")
    suspend fun getImages(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double): Response<List<Photo>>
}
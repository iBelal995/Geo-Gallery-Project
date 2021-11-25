package com.example.geogalleryproject.repositories

import android.content.Context
import com.example.geogalleryproject.api.IGeoGalleryApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.Exception


private const val TAG = "ApiServicesRepository"
private const val BASE_URL = "https://www.flickr.com"
class ApiServicesRepository(context: Context) {

    private val retrofitService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val retrofitApi = retrofitService.create(IGeoGalleryApi::class.java)

    suspend fun getImages(lat: Double, lon:Double ) = retrofitApi.getImages(lat, lon)


    companion object{

        private var instance: ApiServicesRepository? = null

        fun init(context: Context){
            if (instance == null)
                instance = ApiServicesRepository(context)
        }

        fun get(): ApiServicesRepository{
            return instance?: throw Exception("ApiServicesRepository must be initialized")
        }
    }
}
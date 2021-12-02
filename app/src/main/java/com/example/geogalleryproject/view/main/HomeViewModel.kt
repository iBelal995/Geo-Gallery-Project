package com.example.geogalleryproject.view.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogalleryproject.model.photo.GeoGalleryModel
import com.example.geogalleryproject.model.photo.Photo
import com.example.geogalleryproject.model.photo.Photos
import com.example.geogalleryproject.repositories.ApiServicesRepository
import com.example.geogalleryproject.repositories.RoomServiceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception


private const val TAG = "HomeViewModel"
class HomeViewModel : ViewModel(){
    private val apiService = ApiServicesRepository.get()

    val photoLiveData = MutableLiveData<GeoGalleryModel>()
    val photoRoomLivedata = MutableLiveData<List<Photo>>()
    val photoErrorLiveData = MutableLiveData<String>()
    val databaseRepo=  RoomServiceRepository.get()

    fun callPhoto(){
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val response = apiService.getImages(26.3946724, 50.1952603)
                if(response.isSuccessful){
                    response.body()?.run {
                        Log.d(TAG,response.body().toString())
                        photoLiveData.postValue(this)
                        databaseRepo.insertPhotos(photos.photo)
                    }
                }else{
                    Log.d(TAG,response.message())
                    photoErrorLiveData.postValue(response.message())
                    photoRoomLivedata.postValue(databaseRepo.getPhoto())

                }

            }catch (e: Exception){

                photoRoomLivedata.postValue(databaseRepo.getPhoto())

                Log.d(TAG, e.message.toString())
                photoErrorLiveData.postValue(e.message.toString())

            }
        }
    }
}
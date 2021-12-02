package com.example.geogalleryproject.view

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.geogalleryproject.model.photo.Photo
import com.example.geogalleryproject.repositories.ApiServicesRepository
import com.example.geogalleryproject.repositories.RoomServiceRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private const val TAG = "FavoriteViewModel"
class FavoriteViewModel : ViewModel() {

    private val apiRepo = ApiServicesRepository.get()

    val favoritesLiveData = MutableLiveData<List<Photo>>()
    val favoritesErrorLiveData = MutableLiveData<String>()
    val roomRepo = RoomServiceRepository.get()





    fun callFavorite(){
        viewModelScope.launch(Dispatchers.IO) {

            try {
                val response = roomRepo.getFavorites()


                response.run {
                    favoritesLiveData.postValue(response)
                    Log.d(TAG,this.toString())
                }

            } catch (e:Exception){
                Log.d(TAG, e.message.toString())
                favoritesErrorLiveData.postValue(e.message.toString())
            }
        }

    }


    fun callUpdate(photo: Photo){
        viewModelScope.launch(Dispatchers.IO) {

            try {

                 roomRepo.updateIsFavorite(photo)

            } catch (e:Exception){
                Log.d(TAG, e.message.toString())
                favoritesErrorLiveData.postValue(e.message.toString())
            }
        }

    }
}
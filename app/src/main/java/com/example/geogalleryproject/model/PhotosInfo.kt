package com.example.geogalleryproject.model


import com.google.gson.annotations.SerializedName

data class PhotosInfo(
    @SerializedName("photo")
    val photo: PhotoX
)
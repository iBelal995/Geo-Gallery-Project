package com.example.geogalleryproject.model


import com.google.gson.annotations.SerializedName


data class GeoGalleryModel(
    @SerializedName("photos")
    val photos: Photos
)
package com.example.geogalleryproject.model.photo


import com.example.geogalleryproject.model.photo.Photo
import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("page")
    val page: Int,
    @SerializedName("pages")
    val pages: Int,
    @SerializedName("perpage")
    val perpage: Int,
    @SerializedName("photo")
    val photo: List<Photo>,
    @SerializedName("total")
    val total: Int
)
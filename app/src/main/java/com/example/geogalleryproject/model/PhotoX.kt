package com.example.geogalleryproject.model


import com.google.gson.annotations.SerializedName

data class PhotoX(
    @SerializedName("dateuploaded")
    val dateuploaded: String,
    @SerializedName("farm")
    val farm: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("isfavorite")
    val isfavorite: Int,
    @SerializedName("license")
    val license: String,
    @SerializedName("originalformat")
    val originalformat: String,
    @SerializedName("originalsecret")
    val originalsecret: String,
    @SerializedName("owner")
    val owner: Owner,
    @SerializedName("rotation")
    val rotation: Int,
    @SerializedName("safety_level")
    val safetyLevel: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String
)
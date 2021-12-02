package com.example.geogalleryproject.model.photo


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
@Entity
data class Photo(
    @SerializedName("accuracy")
    val accuracy: String,
    @SerializedName("context")
    val context: Int,
    @SerializedName("farm")
    val farm: Int,
    @SerializedName("geo_is_contact")
    val geoIsContact: Int,
    @SerializedName("geo_is_family")
    val geoIsFamily: Int,
    @SerializedName("geo_is_friend")
    val geoIsFriend: Int,
    @SerializedName("geo_is_public")
    val geoIsPublic: Int,
    @SerializedName("height_m")
    val heightM: Int,
    @SerializedName("id")
    @PrimaryKey
    val id: String,
    @SerializedName("isfamily")
    val isfamily: Int,
    @SerializedName("isfriend")
    val isfriend: Int,
    @SerializedName("ispublic")
    val ispublic: Int,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("owner")
    val owner: String,
    @SerializedName("place_id")
    val placeId: String,
    @SerializedName("secret")
    val secret: String,
    @SerializedName("server")
    val server: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url_m")
    val urlM: String,
    @SerializedName("width_m")
    val widthM: Int,
    @SerializedName("woeid")
    val woeid: String,

    val isFavorite: Boolean = false
)
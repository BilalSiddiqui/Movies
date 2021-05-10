package com.swvl.movies.data.model

import com.google.gson.annotations.SerializedName

data class FlickrSearchResponse(
    val photos: Photos?,
    val stat: String?
)
data class Photos(
    val page: Int?,
    val pages: Int?,
    val perpage: Int?,
    val photo: ArrayList<Photo>?,
    val total: String?
)
data class Photo(
    val farm: Int?,
    val id: String?,
    val owner: String?,
    val secret: String?,
    val server: String?,
    val title: String?
)
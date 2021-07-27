package com.shapps.moviesgo.modal

import com.google.gson.annotations.SerializedName

data class MoviesByImdbId(

    val id: Long,
    @SerializedName("title")
    val original_title: String,
    val poster_path: String
)

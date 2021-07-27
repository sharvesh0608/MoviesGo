package com.shapps.moviesgo.modal

import com.google.gson.annotations.SerializedName

data class Movie (
    @SerializedName("results")
    val upcoming :List<MoviesByImdbId>
        )
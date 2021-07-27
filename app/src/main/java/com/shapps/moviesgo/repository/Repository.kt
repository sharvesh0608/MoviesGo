package com.shapps.moviesgo.repository

import com.shapps.moviesgo.api.RetrofitInstance
import com.shapps.moviesgo.modal.Movie
import com.shapps.moviesgo.modal.MoviesByImdbId
import retrofit2.Response

class Repository {

    suspend fun getMoviebyId():Response<Movie>{
        return RetrofitInstance.api.getMoviebyId()
    }
}
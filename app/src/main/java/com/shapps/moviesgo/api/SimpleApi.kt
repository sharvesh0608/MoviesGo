package com.shapps.moviesgo.api

import com.shapps.moviesgo.modal.Movie
import com.shapps.moviesgo.modal.MoviesByImdbId
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface SimpleApi {

    @GET("3/movie/now_playing")
    suspend fun getMoviebyId(
        @Query("api_key") Key: String = "45ba9cff0f602a9706bde5e544e01877"
    ): Response<Movie>
}
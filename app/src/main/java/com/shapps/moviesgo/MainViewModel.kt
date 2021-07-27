package com.shapps.moviesgo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shapps.moviesgo.modal.Movie
import com.shapps.moviesgo.modal.MoviesByImdbId
import com.shapps.moviesgo.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {
    val movieDetails: MutableLiveData<Response<Movie>> =MutableLiveData()

    fun getMoviebyId(){

        viewModelScope.launch {
            val response: Response<Movie> =repository.getMoviebyId()
            movieDetails.value = response
        }
    }


}
package com.shapps.moviesgo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.shapps.moviesgo.adapters.UpcomingAdapter
import com.shapps.moviesgo.repository.Repository

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainViewModel
    val adapter = UpcomingAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        getMoviebyId()
        SetpuRecyclerView()

    }

    private fun SetpuRecyclerView() {
        val upcoming = findViewById<RecyclerView>(R.id.upcoming)
        upcoming.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        upcoming.adapter = adapter

    }

    private fun getMoviebyId() {
        viewModel.getMoviebyId()
        viewModel.movieDetails.observe(this, Observer { response ->
            if (response.isSuccessful) {
                response.body()?.upcoming?.let { adapter.setData(it) }
            } else {
                Log.d("Response", response.errorBody().toString())

            }
        })
    }
}
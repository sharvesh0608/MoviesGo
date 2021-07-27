package com.shapps.moviesgo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shapps.moviesgo.R
import com.shapps.moviesgo.modal.MoviesByImdbId

class UpcomingAdapter(private val context: Context): RecyclerView.Adapter<UpcomingAdapter.UpcomingVH>() {
private var MovieList = emptyList<MoviesByImdbId>()

    inner class UpcomingVH(itemView: View):RecyclerView.ViewHolder(itemView){
        val poster =itemView.findViewById<ImageView>(R.id.movieImage)
        val title =itemView.findViewById<TextView>(R.id.titleText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingVH {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.homelayout,parent,false )
        val viewHolder =UpcomingVH(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: UpcomingVH, position: Int) {
        holder.title.text= MovieList[position].original_title
        Glide.with(context).load("https://image.tmdb.org/t/p/original${MovieList[position].poster_path}").into(holder.poster)
    }

    override fun getItemCount(): Int {
       return MovieList.size
    }
    fun setData(newList: List<MoviesByImdbId>){
        MovieList=newList
        notifyDataSetChanged()
    }
}
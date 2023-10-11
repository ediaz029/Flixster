package com.example.flixster

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NowPlayingrecyclerViewAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<NowPlayingrecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(mView: View) : RecyclerView.ViewHolder(mView), View.OnClickListener {

        private val posterIV = itemView.findViewById<ImageView>(R.id.posterView)
        private val titleTV = itemView.findViewById<TextView>(R.id.titleView)
        private val descriptionTV = itemView.findViewById<TextView>(R.id.descriptionView)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            titleTV.text = movie.mTitle
            descriptionTV.text = movie.mOverview
            Glide.with(context).load(movie.posterURL).into(posterIV)
        }

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
    }}
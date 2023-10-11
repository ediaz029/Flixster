package com.example.flixster

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

/**
 * [RecyclerView.Adapter] that can display a [BestSellerBook] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 */
class NowPlayingrecyclerViewAdapter(
    private val movies: List<Movie>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<NowPlayingrecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_movie, parent, false)
        return MovieViewHolder(view)
    }

    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */
    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var movieItem: Movie? = null
        val MovieImage: ImageView = mView.findViewById<View>(R.id.posterView) as ImageView
        val MovieTitle: TextView = mView.findViewById<View>(R.id.titleView) as TextView
        val MovieDescription: TextView = mView.findViewById<View>(R.id.descriptionView) as TextView


        override fun toString(): String {
            return MovieTitle.toString() + " '" + MovieDescription.text + "'"
        }
    }
    /**
     * This lets us "bind" each Views in the ViewHolder to its' actual data!
     */
    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.movieItem = movie
        holder.MovieTitle.text = movie.title
        holder.MovieDescription.text = movie.description

        Glide.with(holder.mView)
            .load(movie.posterURL)
            .centerInside()
            .into(holder.MovieImage)

        holder.mView.setOnClickListener {
            holder.movieItem?.let { movie ->
                mListener?.onItemClick(movie)
            }
        }
    }

    /**
     * Remember: RecyclerView adapters require a getItemCount() method.
     */
    override fun getItemCount(): Int {
        return movies.size
    }
}
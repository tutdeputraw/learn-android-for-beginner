package com.example.dicodingaplikasiandroidpemulasubmission.modules.movies.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingaplikasiandroidpemulasubmission.databinding.ItemRowMovieBinding
import com.example.dicodingaplikasiandroidpemulasubmission.modules.detailMovie.DetailMovieActivity
import com.example.dicodingaplikasiandroidpemulasubmission.pojo.Movie

class MovieAdapter(
    private val onClick: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ListViewHolder>() {
    private var movies = ArrayList<Movie>()

    @SuppressLint("NotifyDataSetChanged")
    fun setMovies(movies: ArrayList<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

    class ListViewHolder(val binding: ItemRowMovieBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int {
        Log.d("getItemCount", movies.size.toString())
        return movies.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val movie = movies[position]

        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w185${movie.poster_path}")
            .into(holder.binding.imageView)
        holder.binding.tvTitle.text = movie.title
        holder.binding.tvVoteAverage.text = movie.vote_average.toString()
        holder.binding.tvDescription.text = movie.overview
        holder.itemView.setOnClickListener { onClick(movie) }
//        holder.itemView.setOnClickListener {
//            val intent = Intent(it.context, DetailMovieActivity::class.java)
//            intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie)
////            startActivity(intent)
//            startActivity()
//        }
    }
}
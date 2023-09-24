package com.example.dicodingaplikasiandroidpemulasubmission.modules.movies

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingaplikasiandroidpemulasubmission.databinding.ActivityMoviesBinding
import com.example.dicodingaplikasiandroidpemulasubmission.modules.detailMovie.DetailMovieActivity
import com.example.dicodingaplikasiandroidpemulasubmission.modules.movies.adapter.MovieAdapter
import com.example.dicodingaplikasiandroidpemulasubmission.modules.movies.viewModel.MoviesViewModel
import com.example.dicodingaplikasiandroidpemulasubmission.pojo.Movie

class MoviesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMoviesBinding
    private lateinit var viewModel: MoviesViewModel
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[MoviesViewModel::class.java]
        movieAdapter = MovieAdapter(onClick = { movie -> cardOnClicked(movie) })
        binding = ActivityMoviesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()

        viewModel.getPopularMovie()
        observePopularMovie()
    }

    private fun observePopularMovie() {
        viewModel.observerPopularMovieLiveData().observe(this) {
            movieAdapter.setMovies(it.results)
        }
    }

    private fun setupRecyclerView() {
        binding.movieList.apply {
            layoutManager = LinearLayoutManager(this@MoviesActivity)
            adapter = movieAdapter
        }
    }

    private fun cardOnClicked(movie: Movie) {
        val intent = Intent(this, DetailMovieActivity::class.java)
        intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie)
        startActivity(intent)
    }
}
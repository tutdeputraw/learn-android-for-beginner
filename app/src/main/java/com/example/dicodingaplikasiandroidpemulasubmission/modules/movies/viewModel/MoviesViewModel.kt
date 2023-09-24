package com.example.dicodingaplikasiandroidpemulasubmission.modules.movies.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dicodingaplikasiandroidpemulasubmission.pojo.MovieList
import com.example.dicodingaplikasiandroidpemulasubmission.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesViewModel : ViewModel() {
    private val popularMovieLiveData = MutableLiveData<MovieList>()

    fun getPopularMovie() {
        RetrofitInstance.moviesApi.getPopularMovies().enqueue(object : Callback<MovieList> {
            override fun onResponse(call: Call<MovieList>, response: Response<MovieList>) {
                if (response.body() != null) {
                    popularMovieLiveData.value = response.body()
                }
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Log.d("MoviesViewModel", t.message.toString())
            }
        })
    }

    fun observerPopularMovieLiveData(): LiveData<MovieList> {
        return popularMovieLiveData
    }
}

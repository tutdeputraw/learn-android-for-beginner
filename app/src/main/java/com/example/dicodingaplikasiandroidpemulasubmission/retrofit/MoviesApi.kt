package com.example.dicodingaplikasiandroidpemulasubmission.retrofit

import com.example.dicodingaplikasiandroidpemulasubmission.pojo.Movie
import com.example.dicodingaplikasiandroidpemulasubmission.pojo.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesApi {
    @GET("popular?language=en-US&page=1")
    fun getPopularMovies(): Call<MovieList>

    @GET("{Id}?language=en-US")
    fun getMovieDetail(@Path("Id") id: String): Call<Movie>
}
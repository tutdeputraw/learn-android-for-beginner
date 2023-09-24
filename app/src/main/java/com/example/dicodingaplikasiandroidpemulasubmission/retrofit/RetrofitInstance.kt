package com.example.dicodingaplikasiandroidpemulasubmission.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val moviesApi: MoviesApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/movie/")
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MoviesApi::class.java)
    }
}

val httpClient: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader(
                "Authorization",
                "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJjYzMxMzFlZjA2MTQ2MWFhMWFhODk0OWRmYzQyODEzMSIsInN1YiI6IjYxYWRhMGM5NjJlODZmMDA4ZjNlMGRlMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.CKFDYjESYdbVNRuntRn4rkpihjbv8hiWeyBNg13Rlwo"
            )
            .build()
        chain.proceed(request)
    }
    .build()
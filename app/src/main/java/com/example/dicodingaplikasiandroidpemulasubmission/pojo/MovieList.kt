package com.example.dicodingaplikasiandroidpemulasubmission.pojo

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieList(
    val page: Int,
    val results: ArrayList<Movie>,
    val total_pages: Int,
    val total_results: Int
) : Parcelable
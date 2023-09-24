package com.example.dicodingaplikasiandroidpemulasubmission.modules.detailMovie

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBar
import com.example.dicodingaplikasiandroidpemulasubmission.R
import com.example.dicodingaplikasiandroidpemulasubmission.databinding.ActivityDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailMovieBinding

    companion object {
        const val EXTRA_MOVIE =
            "com.example.dicodingaplikasiandroidpemulasubmission.modules.detailMovie.movie"
    }

    @SuppressLint("AppCompatMethod")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val action: ActionBar = supportActionBar!!
//        action.title = "Detail Page"
//        action.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            androidx.appcompat.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
package com.example.dicodingaplikasiandroidpemulasubmission.modules.aboutMe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicodingaplikasiandroidpemulasubmission.databinding.ActivityAboutMeBinding

class AboutMeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutMeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutMeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
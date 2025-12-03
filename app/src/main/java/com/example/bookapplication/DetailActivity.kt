package com.example.bookapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.bookapplication.databinding.ActivityDetailBinding


class DetailActivity : AppCompatActivity() {

    private lateinit var b: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(b.root)

        // Ambil extras
        val title         = intent.getStringExtra("title").orEmpty()
        val originalTitle = intent.getStringExtra("originalTitle").orEmpty()
        val releaseDate   = intent.getStringExtra("releaseDate").orEmpty()
        val description   = intent.getStringExtra("description").orEmpty()
        val pages         = intent.getIntExtra("pages", 0)
        val cover         = intent.getStringExtra("cover").orEmpty()

        // Tampilkan
        Glide.with(b.imgCoverDetail).load(cover).into(b.imgCoverDetail)
        b.tvTitle.text       = title
        b.tvOriginal.text    = originalTitle
        b.tvRelease.text     = releaseDate
        b.tvDescription.text = description
        b.tvPages.text       = "Pages: $pages"

        b.toolbarDetail.setNavigationOnClickListener { finish() }
    }
}
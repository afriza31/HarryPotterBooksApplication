package com.example.bookapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.databinding.ItemBookBinding


import com.bumptech.glide.Glide

class BookAdapter(
    private var list: List<Book>,
    private val onClick: (Book) -> Unit
) : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemBookBinding)
        : RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) = with(binding) {

//       karena item_book (halaman utama) hanya memuat title, releaseDate, dan cover, sisanya itu di detail activity nanti dengan intent extras
            tvTitle.text = book.title
            tvRelease.text = book.releaseDate
            Glide.with(imgCover)
                .load(book.cover)
                .fitCenter()
                .into(imgCover)
            root.setOnClickListener { onClick(book) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val b = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(b)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}

package com.example.newspage.adapter

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.newspage.R
import com.example.newspage.data.model.Article
import com.example.newspage.databinding.NewsListItemViewBinding

class NewsListAdapter (private val onItemClicked: (Article,position:Int) -> Unit): PagingDataAdapter<Article, NewsListAdapter.NewsViewHolder>(DIFF_UTIL) {

    class NewsViewHolder(private val binding: NewsListItemViewBinding, private val onItemClicked: (Article, position: Int) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(article: Article, position: Int) {
            binding.titleText.text = article.title
            binding.authorText.text = article.author
            binding.newsImage.load(article.imageURL) {
                crossfade(true)
                error(R.drawable.ic_launcher_foreground)
            }
            binding.root.setOnClickListener {
                onItemClicked(article, position)
            }
        }
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it, position) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val binding = NewsListItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding, onItemClicked)
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

        }
    }
}
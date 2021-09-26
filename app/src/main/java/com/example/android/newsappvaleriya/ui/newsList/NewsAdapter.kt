package com.example.android.newsappvaleriya.ui.newsList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.newsappvaleriya.R
import com.example.android.newsappvaleriya.data.Article

class NewsAdapter :
    ListAdapter<Article, NewsAdapter.ArticleViewHolder>(NewsDiffCallback()) {

    class ArticleViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ArticleViewHolder(inflater.inflate(R.layout.article_list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {

    }

}


class NewsDiffCallback : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return areItemsTheSame(oldItem, newItem)
    }

}


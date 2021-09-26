package com.example.android.newsappvaleriya.ui.newsList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.newsappvaleriya.data.Article
import com.example.android.newsappvaleriya.databinding.ArticleListItemBinding

class NewsAdapter :
    ListAdapter<Article, NewsAdapter.ArticleViewHolder>(NewsDiffCallback()) {

    class ArticleViewHolder(val binding: ArticleListItemBinding, val context: Context) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(a: Article) {
            Glide.with(context).load(a.urlToImage).into(binding.itemImg)

            binding.apply {
                itemTitle.text = a.title
                itemDesc.text = a.desc
            }


            itemView.setOnClickListener {
                //todo open details fragment
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ArticleViewHolder(
            ArticleListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            parent.context
        )
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(getItem(position))
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


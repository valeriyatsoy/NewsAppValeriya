package com.example.android.newsappvaleriya.data

import java.net.URL

data class Article(
    val source: ArticleSource,
    val author: String,
    val title: String,
    val desc: String,
    val url: URL,
    val urlToImage: URL,
    val publishedAt: String,
    val content: String
)
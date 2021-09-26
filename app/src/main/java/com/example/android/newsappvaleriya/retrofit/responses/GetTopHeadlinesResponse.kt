package com.example.android.newsappvaleriya.retrofit.responses

import com.example.android.newsappvaleriya.data.Article

data class GetTopHeadlinesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
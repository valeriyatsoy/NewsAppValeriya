package com.example.android.newsappvaleriya.retrofit.responses

import com.example.android.newsappvaleriya.data.Article

class GetTopHeadlinesResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<Article>
)
package com.example.android.newsappvaleriya.repository

import com.example.android.newsappvaleriya.retrofit.APIService
import com.example.android.newsappvaleriya.retrofit.requests.GetTopHeadlinesRequest
import com.example.android.newsappvaleriya.utils.Constants
import javax.inject.Inject

class NewsRepository
@Inject
constructor(private val apiService: APIService) {
    suspend fun getTopHeadlines(request: GetTopHeadlinesRequest) = apiService.getTopHeadlines(request.country, request.category, Constants.NEWS_API_KEY)
}

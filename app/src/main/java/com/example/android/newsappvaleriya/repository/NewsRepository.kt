package com.example.android.newsappvaleriya.repository

import com.example.android.newsappvaleriya.retrofit.requests.GetTopHeadlinesRequest
import mm.com.csstechnology.elottery.retrofit.APIService
import javax.inject.Inject

class NewsRepository
@Inject
constructor(private val apiService: APIService) {
    suspend fun getTopHeadlines(request: GetTopHeadlinesRequest) = apiService.getTopHeadlines(request.country, request.category)
}

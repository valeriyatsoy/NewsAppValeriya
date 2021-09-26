package com.example.android.newsappvaleriya.repository

import com.example.android.newsappvaleriya.retrofit.requests.GetTopHeadlinesRequest
import mm.com.csstechnology.elottery.retrofit.APIInterface
import javax.inject.Inject

class NewsRepository
@Inject
constructor(private val apiInterface: APIInterface) {
    suspend fun getTopHeadlines(request: GetTopHeadlinesRequest) = apiInterface.getTopHeadlines(request.country, request.category)
}

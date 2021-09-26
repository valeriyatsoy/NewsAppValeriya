package com.example.android.newsappvaleriya.retrofit

import com.example.android.newsappvaleriya.retrofit.responses.GetTopHeadlinesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String,
        @Query("category") category: String,
        @Query("apiKey") apiKey: String,
    ): Response<GetTopHeadlinesResponse>
}
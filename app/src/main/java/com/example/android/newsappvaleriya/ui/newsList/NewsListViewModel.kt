package com.example.android.newsappvaleriya.ui.newsList

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.newsappvaleriya.data.Article
import com.example.android.newsappvaleriya.repository.NewsRepository
import com.example.android.newsappvaleriya.retrofit.requests.GetTopHeadlinesRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsListViewModel
@Inject
constructor
    (private val repository: NewsRepository) : ViewModel() {

    private val _response = MutableLiveData<List<Article>>()
    val responseNews: LiveData<List<Article>>
        get() = _response

    init {
        getTopHeadlines()
    }

    private fun getTopHeadlines() = viewModelScope.launch {
        repository.getTopHeadlines(GetTopHeadlinesRequest("us", "business")).let { response ->
            if (response.isSuccessful && response.body() != null) {
                _response.postValue(response.body()!!.articles)
            } else {
                Log.d("getTopHeadlines", "Error: ${response.code()}")
            }
        }
    }
}
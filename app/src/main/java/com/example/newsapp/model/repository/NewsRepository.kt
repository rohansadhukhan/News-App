package com.example.newsapp.model.repository

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.model.database.entity.Article
import com.example.newsapp.model.network.RetrofitService
import com.example.newsapp.view.data.News
import kotlinx.coroutines.launch

private val TAG: String = "betaTesting"

class NewsRepository(val application: Application) : ViewModel() {

    var newsList: MutableLiveData<List<Article>>? = MutableLiveData<List<Article>>()

    fun getTopNews(country: String, pageNumber: Int) = viewModelScope.launch {
        val response = RetrofitService.api.getTopHeadline(country, pageNumber)
        if (response.isSuccessful) {
            var cur: News = response.body()!!
            newsList?.value = cur.articles
        } else {
            Log.d(TAG, response.code().toString())
        }
    }
}

package com.example.newsapp.model.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.newsapp.model.database.Article
import com.example.newsapp.model.database.ArticleDatabase
import com.example.newsapp.model.network.RetrofitService
import com.example.newsapp.view.data.News

private const val TAG: String = "rohan"

class NewsRepository(
    val database: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode : String, pageNumber : Int) =
        RetrofitService.api.getTopHeadline(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitService.api.getSearchNews(searchQuery, pageNumber)
}

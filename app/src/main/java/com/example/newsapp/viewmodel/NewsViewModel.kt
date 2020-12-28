package com.example.newsapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.newsapp.model.database.entity.Article
import com.example.newsapp.model.repository.NewsRepository

class NewsViewModel(application: Application) : AndroidViewModel(application) {

    val newsList: LiveData<List<Article>>
    private val repository: NewsRepository = NewsRepository(application)
    private val pageNumber: Int = 1

    init {
        newsList = repository.newsList!!
    }

    fun getTopNews(country: String) {
        repository.getTopNews(country, pageNumber)
    }

}
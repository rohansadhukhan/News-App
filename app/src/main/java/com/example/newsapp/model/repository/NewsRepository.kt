package com.example.newsapp.model.repository

import com.example.newsapp.model.database.Article
import com.example.newsapp.model.database.ArticleDatabase
import com.example.newsapp.model.network.RetrofitService

private const val TAG: String = "rohan"

class NewsRepository(
    val database: ArticleDatabase
) {
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitService.api.getTopHeadline(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitService.api.getSearchNews(searchQuery, pageNumber)

    suspend fun insert(article: Article) = database.getArticleDao().insert(article)

    fun getSavedNews() = database.getArticleDao().getArticles()

    suspend fun deleteArticle(article: Article) = database.getArticleDao().delete(article)
}

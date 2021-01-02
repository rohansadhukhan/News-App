package com.example.newsapp.model.network

import com.example.newsapp.utility.Constants.Companion.API_KEY
import com.example.newsapp.view.data.News
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface APiService {

    @GET("top-headlines")
    suspend fun getTopHeadline(
        @Query("country") countryCode: String = "in",
        @Query("page") pageNumber: Int = 1,
        @Query("apikey") apiKey: String = API_KEY
    ): Response<News>

    @GET("everything")
    suspend fun getSearchNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apikey") apiKey: String = API_KEY
    ): Response<News>

}
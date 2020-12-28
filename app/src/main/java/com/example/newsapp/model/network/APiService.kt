package com.example.newsapp.model.network

import com.example.newsapp.view.data.News
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY: String = "123383e6be5d4c24aadc951aba72be58"
const val BASE_URL: String = "https://newsapi.org/v2/"

interface APiService {

    @GET("top-headlines")
    suspend fun getTopHeadline(
        @Query("country") countryCode: String = "in",
        @Query("page") pageNumber : Int = 1,
        @Query("apikey") apiKey : String = API_KEY
    ) : Response<News>

    @GET("everything")
    fun getSearchNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber : Int = 1,
        @Query("apikey") apiKey : String = API_KEY
    ) : Response<News>

}
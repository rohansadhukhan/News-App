package com.example.newsapp.view.data

import com.example.newsapp.model.database.Article

data class News(
    val status : String,
    val totalResults : Int,
    val articles : List<Article>?
) {
}
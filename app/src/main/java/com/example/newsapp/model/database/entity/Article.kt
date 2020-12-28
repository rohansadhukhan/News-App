package com.example.newsapp.model.database.entity

import com.example.newsapp.view.data.Source

class Article(
    val source : Source,
    val author : String?,
    val title : String?,
    val description : String?,
    val url : String?,
    val urlToImage : String?,
    val publishedAt : String?,
    val content : String?,
) {
}
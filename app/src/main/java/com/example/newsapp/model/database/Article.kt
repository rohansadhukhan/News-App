package com.example.newsapp.model.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.newsapp.view.data.Source

@Entity(
    tableName = "articles"
)
class Article(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String,
) {
}
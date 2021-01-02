package com.example.newsapp.model.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.newsapp.model.database.entity.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article): Long

    @Query("SELECT * FROM articles")
    fun getArticles(): LiveData<List<Article>>

    @Delete
    suspend fun delete(article: Article)
}
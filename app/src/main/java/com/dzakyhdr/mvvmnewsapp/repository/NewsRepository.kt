package com.dzakyhdr.mvvmnewsapp.repository

import com.dzakyhdr.mvvmnewsapp.database.ArticleDatabase
import com.dzakyhdr.mvvmnewsapp.model.Article
import com.dzakyhdr.mvvmnewsapp.network.RetrofitInstance

class NewsRepository(val db: ArticleDatabase) {

    //get semua data untuk di tampilkan di fragment breaking news
    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)

    //membuat database baru di local database
    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)

    //untuk get semua data yang sudah di bookmark
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    //delete database local
    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}
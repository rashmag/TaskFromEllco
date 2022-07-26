package com.example.taskfromellco.data.remote_db

data class NewsResponce(
    val articles: List<ArticleModel>,
    val status: String,
    val totalResults: Int
)
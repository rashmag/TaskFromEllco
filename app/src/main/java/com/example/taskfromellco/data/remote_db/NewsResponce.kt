package com.example.taskfromellco.data.remote_db

data class NewsResponce(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)
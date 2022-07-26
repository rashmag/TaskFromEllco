package com.example.taskfromellco.data.remote_db

data class ArticleModel(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
//    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String,
    var isFavorite: Boolean
)
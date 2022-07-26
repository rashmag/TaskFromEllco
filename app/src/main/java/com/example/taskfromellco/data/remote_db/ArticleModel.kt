package com.example.taskfromellco.data.remote_db

import com.google.gson.annotations.SerializedName

data class ArticleModel(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: String,
    val title: String,
    val url: String,
    val urlToImage: String
)
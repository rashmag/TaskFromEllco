package com.example.taskfromellco.data.remote_db

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleModel(
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
//    val source: Source? = null,
    val title: String,
    val url: String,
    val urlToImage: String,
    var isFavorite: Boolean
) : Parcelable
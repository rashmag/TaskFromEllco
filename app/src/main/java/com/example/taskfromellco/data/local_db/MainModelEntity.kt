package com.example.taskfromellco.data.local_db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_db")
data class MainModelEntity(
    @PrimaryKey(autoGenerate = true)
    val id:Int = 0,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String,
    var isFavorite: Boolean
)

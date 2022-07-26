package com.example.taskfromellco.data.utils

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_db")
data class MainModel(
    @PrimaryKey(autoGenerate = false)
    val id:Int = 0,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
    val source: String,
    val title: String,
    val url: String,
    val urlToImage: String
)

package com.example.taskfromellco.data.local_db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.example.taskfromellco.data.remote_db.Source

@Entity(tableName = "remote_db")
data class MainModelEntity(
    @PrimaryKey(autoGenerate = false)
    val id:Int,
    val author: String,
    val content: String,
    val description: String,
    val publishedAt: String,
//    @TypeConverters(SourceConverter::class)
//    val source: Source,
    val title: String,
    val url: String,
    val urlToImage: String,
    var isFavorite: Boolean
)

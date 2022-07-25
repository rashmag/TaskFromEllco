package com.example.taskfromellco.data.utils

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "remote_db")
data class MainModel(
    @PrimaryKey(autoGenerate = false)
    val id:Int = 0,
    var value: String
)

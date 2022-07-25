package com.example.taskfromellco.data.local_db

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskfromellco.data.utils.MainModel

@Database(entities = [MainModel::class], version = 1, exportSchema = false)
abstract class MainDataBase : RoomDatabase(){

    abstract fun mainDao():MainDao

    companion object {
        private var INSTANCE: MainDataBase? = null
        private val LOCK = Any()
        private const val DB_NAME = "remote_db"

        fun getInstance(application: Application):MainDataBase{
            INSTANCE?.let {
                return it
            }

            synchronized(LOCK){
                INSTANCE?.let {
                    return it
                }

                val db = Room.databaseBuilder(
                    application,
                    MainDataBase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = db
                return db
            }
        }
    }
}
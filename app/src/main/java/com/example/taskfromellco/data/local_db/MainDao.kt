package com.example.taskfromellco.data.local_db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.taskfromellco.data.utils.MainModel

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveValue(mainModel: MainModel)

    @Query("SELECT * FROM remote_db")
    fun getAllData(): List<MainModel>

    @Delete
    fun deleteUser(mainModel: MainModel?)
}
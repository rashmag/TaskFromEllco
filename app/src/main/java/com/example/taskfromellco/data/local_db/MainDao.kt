package com.example.taskfromellco.data.local_db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveValue(mainModelEntity: MainModelEntity)

    @Query("SELECT * FROM remote_db")
    fun getAllData(): LiveData<List<MainModelEntity>>

    @Delete
    suspend fun deleteUser(mainModelEntity: MainModelEntity?):Int
}
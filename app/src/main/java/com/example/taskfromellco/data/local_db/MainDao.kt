package com.example.taskfromellco.data.local_db

import androidx.room.*

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveValue(mainModelEntity: MainModelEntity)

    @Query("SELECT * FROM remote_db")
    suspend fun getAllData(): List<MainModelEntity>

    @Delete
    suspend fun deleteUser(mainModelEntity: MainModelEntity?):Int
}
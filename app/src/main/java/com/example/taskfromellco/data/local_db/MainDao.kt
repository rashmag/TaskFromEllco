package com.example.taskfromellco.data.local_db

import androidx.room.*

@Dao
interface MainDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveValue(mainModelEntity: MainModelEntity)

    @Query("SELECT * FROM remote_db")
    fun getAllData(): List<MainModelEntity>

    @Delete
    fun deleteUser(mainModelEntity: MainModelEntity?):Int
}
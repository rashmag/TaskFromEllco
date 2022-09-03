package com.example.taskfromellco.domain.repository

import androidx.lifecycle.LiveData
import com.example.taskfromellco.domain.model.ArticalDomainModel

interface DataRep {
    fun loadData(): LiveData<List<ArticalDomainModel>>
    fun loadText(): String
    fun saveText(): Boolean
    suspend fun saveData(value:ArticalDomainModel)
    suspend fun deleteData(value:ArticalDomainModel):Int
}
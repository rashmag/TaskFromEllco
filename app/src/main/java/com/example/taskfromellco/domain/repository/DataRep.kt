package com.example.taskfromellco.domain.repository

import com.example.taskfromellco.domain.model.ArticalDomainModel

interface DataRep {
    suspend fun loadData(): List<ArticalDomainModel>
    fun loadText(): String
    fun saveText(): Boolean
    suspend fun saveData(value:ArticalDomainModel)
    suspend fun deleteData(value:ArticalDomainModel):Int
}
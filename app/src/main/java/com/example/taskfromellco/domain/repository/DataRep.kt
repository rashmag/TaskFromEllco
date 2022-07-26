package com.example.taskfromellco.domain.repository

import com.example.taskfromellco.domain.model.ArticalDomainModel

interface DataRep {
    fun loadData(): List<ArticalDomainModel>
    fun saveData(value:ArticalDomainModel)
    fun deleteData(value:ArticalDomainModel):Int
}
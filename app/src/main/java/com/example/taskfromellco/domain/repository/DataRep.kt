package com.example.taskfromellco.domain.repository

import androidx.lifecycle.LiveData
import com.example.taskfromellco.domain.model.DBModel

interface DataRep {
    fun loadData(): LiveData<List<DBModel>>
    fun saveData(value:DBModel)
}
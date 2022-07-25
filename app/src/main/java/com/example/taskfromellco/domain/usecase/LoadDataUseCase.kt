package com.example.taskfromellco.domain.usecase

import androidx.lifecycle.LiveData
import com.example.taskfromellco.domain.model.DBModel
import com.example.taskfromellco.domain.repository.DataRep

class LoadDataUseCase (private val dataRep: DataRep){
    operator fun invoke():LiveData<DBModel> = dataRep.loadData()
}
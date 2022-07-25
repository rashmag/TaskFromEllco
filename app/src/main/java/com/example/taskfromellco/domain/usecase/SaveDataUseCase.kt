package com.example.taskfromellco.domain.usecase

import com.example.taskfromellco.domain.model.DBModel
import com.example.taskfromellco.domain.repository.DataRep

class SaveDataUseCase (private val dataRep: DataRep){
    operator fun invoke(value: DBModel) = dataRep.saveData(value)
}
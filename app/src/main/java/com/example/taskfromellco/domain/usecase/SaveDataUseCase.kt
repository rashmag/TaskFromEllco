package com.example.taskfromellco.domain.usecase

import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.repository.DataRep
import javax.inject.Inject

class SaveDataUseCase @Inject constructor(private val dataRep: DataRep){
    suspend operator fun invoke(value: ArticalDomainModel) = dataRep.saveData(value)
}
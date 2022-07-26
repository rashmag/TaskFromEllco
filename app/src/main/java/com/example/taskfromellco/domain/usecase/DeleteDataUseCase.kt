package com.example.taskfromellco.domain.usecase

import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.repository.DataRep
import javax.inject.Inject

class DeleteDataUseCase @Inject constructor(private val dataRep: DataRep){
    operator fun invoke(value: ArticalDomainModel):Int = dataRep.deleteData(value)
}
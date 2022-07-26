package com.example.taskfromellco.domain.usecase

import androidx.lifecycle.LiveData
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.repository.DataRep
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val dataRep: DataRep) {
    suspend operator fun invoke(): List<ArticalDomainModel> = dataRep.loadData()
}
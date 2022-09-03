package com.example.taskfromellco.domain.usecase

import androidx.lifecycle.LiveData
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.repository.DataRep
import javax.inject.Inject

class LoadDataUseCase @Inject constructor(private val dataRep: DataRep) {
    operator fun invoke(): LiveData<List<ArticalDomainModel>> = dataRep.loadData()
}
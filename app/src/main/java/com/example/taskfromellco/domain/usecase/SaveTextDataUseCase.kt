package com.example.taskfromellco.domain.usecase

import androidx.lifecycle.LiveData
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.repository.DataRep
import javax.inject.Inject

class SaveTextDataUseCase @Inject constructor(private val dataRep: DataRep) {
    operator fun invoke(name:String): Boolean {
        val oldName = dataRep.loadText()
        if(oldName.equals(name)){
            return true
        }

        return dataRep.saveText()
    }
}
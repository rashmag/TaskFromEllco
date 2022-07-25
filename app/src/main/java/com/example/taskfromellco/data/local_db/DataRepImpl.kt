package com.example.taskfromellco.data.local_db

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.taskfromellco.data.utils.MainMapper
import com.example.taskfromellco.domain.model.DBModel
import com.example.taskfromellco.domain.repository.DataRep

class DataRepImpl(application: Application) : DataRep {
    private val mainDao = MainDataBase.getInstance(application).mainDao()
    private val mapper = MainMapper()
    override fun loadData(): LiveData<List<DBModel>> = MediatorLiveData<List<DBModel>>().apply {
        addSource(mainDao.getAllData()){
            postValue(mapper.mapListMainModelToListEntity(it))
        }
    }

    override fun saveData(value: DBModel)= mainDao.saveValue(mapper.mapDBModelToMainModel(value))
}
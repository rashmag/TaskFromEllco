package com.example.taskfromellco.data.local_db

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.taskfromellco.utils.MainMapper
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.repository.DataRep
import com.example.taskfromellco.utils.AppScope
import javax.inject.Inject

@AppScope
class DataRepImpl @Inject constructor(application: Application) : DataRep {
    private val mainDao = MainDataBase.getInstance(application).mainDao()
    private val mapper = MainMapper()
    override fun loadData():List<ArticalDomainModel> = mapper.mapListMainModelToListEntity(mainDao.getAllData())


//        MediatorLiveData<ArticalDomainModel>().apply {
//        addSource(mainDao.getAllData()){
//            postValue(mapper.mapMainModelToArticalDomainModel(it))
//        }
//    }

    override fun saveData(value: ArticalDomainModel) = mainDao.saveValue(mapper.mapArticalDomainModelToMainModel(value))


    override fun deleteData(value: ArticalDomainModel):Int = mainDao.deleteUser(mapper.mapArticalDomainModelToMainModelDelete(value))


}
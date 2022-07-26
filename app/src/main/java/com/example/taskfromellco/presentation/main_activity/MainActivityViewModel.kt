package com.example.taskfromellco.presentation.main_activity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskfromellco.data.local_db.DataRepImpl
import com.example.taskfromellco.data.utils.MainModel
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.usecase.LoadDataUseCase
import com.example.taskfromellco.domain.usecase.SaveDataUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private val dataRep = DataRepImpl(application)
    private val coroutines = CoroutineScope(Dispatchers.IO)
    private val loadDataUseCase = LoadDataUseCase(dataRep)
    private val saveDataUseCase = SaveDataUseCase(dataRep)

    val valueList = loadDataUseCase.invoke()

    private var _value = MutableLiveData<MainModel>()
    val value: LiveData<MainModel> get() = _value

    fun saveValue(value: ArticalDomainModel) {
        coroutines.launch {
            saveDataUseCase.invoke(value)
        }
    }
}
package com.example.taskfromellco.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.usecase.DeleteDataUseCase
import com.example.taskfromellco.domain.usecase.LoadDataUseCase
import com.example.taskfromellco.domain.usecase.SaveDataUseCase
import javax.inject.Inject
import kotlin.concurrent.thread

class FavoriteViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase,
    private val deleteDataUseCase: DeleteDataUseCase
) : ViewModel() {

    fun loadAllList(): List<ArticalDomainModel> {
        return loadDataUseCase.invoke()
    }


    fun deleteArticle(articalDomainModel: ArticalDomainModel) {
        thread {
            deleteDataUseCase.invoke(articalDomainModel)
        }
    }
}
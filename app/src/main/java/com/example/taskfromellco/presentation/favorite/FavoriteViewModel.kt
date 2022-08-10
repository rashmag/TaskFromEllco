package com.example.taskfromellco.presentation.favorite

import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.usecase.DeleteDataUseCase
import com.example.taskfromellco.domain.usecase.LoadDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavoriteViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase,
    private val deleteDataUseCase: DeleteDataUseCase
) : ViewModel() {

    fun setupSearchView(searchViewFavorite: SearchView, adapterFavorite: AdapterFavorite) {
        searchViewFavorite.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                viewModelScope.launch {
                    loadAllList {
                        adapterFavorite.submitList(it)
                    }
                }
                return false
            }
        })

        val articalDomainModel = arrayListOf<ArticalDomainModel>()
        searchViewFavorite.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                articalDomainModel.clear()
                viewModelScope.launch {
                    loadAllList {
                        it.forEach {
                            if ((it.author?.lowercase())!!.contains(
                                    newText?.lowercase().toString()
                                )
                            ) {
                                articalDomainModel.add(it)
                            }
                        }
                        adapterFavorite.submitList(articalDomainModel)
                    }
                }
                return false
            }
        })
    }

    suspend fun loadAllList(articalDomainModel: (List<ArticalDomainModel>) -> Unit) {
        withContext(Dispatchers.IO) {
            articalDomainModel.invoke(loadDataUseCase.invoke())
        }
    }


    fun deleteArticle(articalDomainModel: ArticalDomainModel, selectResult: (Int) -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                selectResult.invoke(deleteDataUseCase.invoke(articalDomainModel))
            }
        }
    }
}
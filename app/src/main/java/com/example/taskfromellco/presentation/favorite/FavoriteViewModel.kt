package com.example.taskfromellco.presentation.favorite

import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModel
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.usecase.DeleteDataUseCase
import com.example.taskfromellco.domain.usecase.LoadDataUseCase
import javax.inject.Inject
import kotlin.concurrent.thread

class FavoriteViewModel @Inject constructor(
    private val loadDataUseCase: LoadDataUseCase,
    private val deleteDataUseCase: DeleteDataUseCase
) : ViewModel() {

    fun setupSearchView(searchViewFavorite: SearchView, adapterFavorite: AdapterFavorite) {
        searchViewFavorite.setOnCloseListener(object : SearchView.OnCloseListener {
            override fun onClose(): Boolean {
                thread {
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
                thread {
                    loadAllList {
                        it.forEach {
                            if ((it.author?.toLowerCase()).equals(query?.toLowerCase())) {
//                            Log.d("test1","size = ${it.author?.toLowerCase()} = ${query?.toLowerCase()}")
                                articalDomainModel.add(it)
                            }
                        }
                        adapterFavorite.submitList(articalDomainModel)
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    fun loadAllList(articalDomainModel: (List<ArticalDomainModel>) -> Unit) {
        thread { articalDomainModel.invoke(loadDataUseCase.invoke()) }
    }


    fun deleteArticle(articalDomainModel: ArticalDomainModel, selectResult: (Int) -> Unit) {
        thread {
            selectResult.invoke(deleteDataUseCase.invoke(articalDomainModel))
        }
    }
}
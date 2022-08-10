package com.example.taskfromellco.presentation.lenta

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.taskfromellco.data.remote_db.ApiClient
import com.example.taskfromellco.data.remote_db.ArticleModel
import com.example.taskfromellco.data.remote_db.NewsResponce
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.usecase.SaveDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LentaViewModel @Inject constructor(
    private val saveDataUseCase: SaveDataUseCase,
) : ViewModel() {
    fun saveArticleModel(articalDomainModel: ArticalDomainModel) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                saveDataUseCase.invoke(articalDomainModel)
            }
        }
    }

    fun getAllNewsRetrofit(callback: (List<ArticleModel>) -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                ApiClient.getClient().getAllNews("ru", ApiClient.API_KEY).enqueue(object :
                    Callback<NewsResponce> {
                    override fun onResponse(
                        call: Call<NewsResponce>,
                        response: Response<NewsResponce>
                    ) {
                        val articles = response.body()?.articles

                        if (response.isSuccessful && articles?.isNotEmpty() == true) {
                            callback.invoke(articles)
                        } else {
                            Log.d("test1", "not result")
                        }
                    }

                    override fun onFailure(call: Call<NewsResponce>, t: Throwable) {
                        Log.d("test1", "onFailure $t")
                    }
                })
            }
        }
    }

    fun searchQuery(query: String, callback: (List<ArticleModel>) -> Unit) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                ApiClient.getClient().getSearchNews("ru", query, ApiClient.API_KEY).enqueue(object :
                    Callback<NewsResponce> {
                    override fun onResponse(
                        call: Call<NewsResponce>,
                        response: Response<NewsResponce>
                    ) {
                        val articles = response.body()?.articles

                        if (response.isSuccessful && articles?.isNotEmpty() == true) {
                            callback.invoke(articles)
                        } else {
                            Log.d("test1", "not result search $query")
                        }
                    }

                    override fun onFailure(call: Call<NewsResponce>, t: Throwable) {
                        Log.d("test1", "onFailure $t")
                    }
                })
            }
        }
    }
}
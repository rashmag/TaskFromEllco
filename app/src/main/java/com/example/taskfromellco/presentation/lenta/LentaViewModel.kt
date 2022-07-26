package com.example.taskfromellco.presentation.lenta

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.taskfromellco.data.remote_db.*
import com.example.taskfromellco.domain.model.ArticalDomainModel
import com.example.taskfromellco.domain.usecase.LoadDataUseCase
import com.example.taskfromellco.domain.usecase.SaveDataUseCase
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LentaViewModel @Inject constructor(
    private val saveDataUseCase: SaveDataUseCase
) : ViewModel() {
    private val dataManager = DataManager()
    private val scope = CoroutineScope(Dispatchers.IO)


    fun saveArticle(articalDomainModel: ArticalDomainModel){
        saveDataUseCase.invoke(articalDomainModel)
    }

    fun getAllNews(callback: (List<ArticleModel>) -> Unit) {
        scope.launch {
            ApiClient.getClient().getAllNews("ru", ApiClient.API_KEY).enqueue(object :
                Callback<NewsResponce> {
                override fun onResponse(
                    call: Call<NewsResponce>,
                    response: Response<NewsResponce>
                ) {
                    val responseBody = response.body()!!

                    if (response.isSuccessful && responseBody.articles.isNotEmpty() == true) {
                        callback.invoke(responseBody.articles)
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

    fun searchQuery(query: String,callback: (List<ArticleModel>) -> Unit){
            scope.launch {
                ApiClient.getClient().getSearchNews("ru",query, ApiClient.API_KEY).enqueue(object :
                    Callback<NewsResponce> {
                    override fun onResponse(
                        call: Call<NewsResponce>,
                        response: Response<NewsResponce>
                    ) {
                        val responseBody = response.body()!!

                        if (response.isSuccessful && responseBody.articles.isNotEmpty() == true) {
                            callback.invoke(responseBody.articles)
                        } else {
                            Log.d("test1", "not result search $query")
                        }
                    }

                    override fun onFailure(call: Call<NewsResponce>, t: Throwable) {
                        TODO("Not yet implemented")
                    }
                })
            }
    }
}
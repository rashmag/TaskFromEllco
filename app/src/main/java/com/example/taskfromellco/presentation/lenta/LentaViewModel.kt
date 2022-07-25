package com.example.taskfromellco.presentation.lenta

import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.taskfromellco.data.remote_db.ApiClient
import com.example.taskfromellco.data.remote_db.DataManager
import com.example.taskfromellco.data.remote_db.Source
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class LentaViewModel : ViewModel() {
    private val dataManager = DataManager()
    private val scope = CoroutineScope(Dispatchers.IO)
    fun getEverything(query: String, page: Int, apiKey: String) {
        scope.launch {
            dataManager.getEverything(query, page, apiKey)
        }
    }

    fun getHeadlines(countryCode: String, page: Int, apiKey: String) {
        scope.launch {
            dataManager.getHeadlines(countryCode, page, apiKey)
        }
    }

    fun getData() {
//        scope.launch {
//            ApiClient.getClient().getHeadlines("ru", 1, ApiClient.API_KEY).enqueue(object :
//                Callback<List<Source>> {
//                override fun onResponse(
//                    call: Call<List<Source>>,
//                    response: Response<List<Source>>
//                ) {
//                    val responseBody = response.body()!!
//
//                    val stringBuilder = StringBuilder()
//                    for (myData in responseBody) {
//                        stringBuilder.append(myData.id)
//                        stringBuilder.append("\n")
//                    }
//                    Log.d("test1","$stringBuilder")
//                }
//
//                override fun onFailure(call: Call<List<Source>>, t: Throwable) {
//                    TODO("Not yet implemented")
//                }
//            })
//        }
    }
}
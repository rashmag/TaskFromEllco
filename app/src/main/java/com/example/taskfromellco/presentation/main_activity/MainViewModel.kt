package com.example.taskfromellco.presentation.main_activity

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.lang.RuntimeException

class MainViewModel : ViewModel() {
    private val parentJob = Job()
    private val exeptionHandler = CoroutineExceptionHandler { _, throwable ->
        Log.d("test1","Exeption ${throwable}")
    }
    private val scope = CoroutineScope(Dispatchers.Main + parentJob + exeptionHandler)

    fun method(){
        val childJob1 = scope.launch {
            delay(3000)
            Log.d("test1","first coroutine finished")
        }
        val childJob2 = scope.launch {
            delay(3000)
            Log.d("test1","second coroutine finished")
        }
        val childJob3 = scope.launch {
            delay(3000)
            errorExeption()
            Log.d("test1","three coroutine finished")
        }
    }

    private fun errorExeption() {
        throw RuntimeException()
    }
}
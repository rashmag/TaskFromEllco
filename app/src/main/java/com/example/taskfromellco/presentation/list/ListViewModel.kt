package com.example.taskfromellco.presentation.list

import androidx.lifecycle.ViewModel
import com.example.taskfromellco.R
import javax.inject.Inject

class ListViewModel @Inject constructor(): ViewModel() {

    fun createList(): ArrayList<ListModel> {
        val arrayList: ArrayList<ListModel> = arrayListOf()
        repeat(20) {
            arrayList.add(ListModel(R.drawable.ic_launcher_background, "Название $it"))
        }
        return arrayList
    }
}
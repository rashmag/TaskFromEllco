package com.example.taskfromellco.presentation.list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Это интерфейс-маркер - то есть ничего определять не нужно
@Parcelize
data class ListModel(val img:Int,val value: String) : Parcelable
package com.example.taskfromellco.presentation.list

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListModel(val img:Int,val value: String) : Parcelable
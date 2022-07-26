package com.example.taskfromellco.utils

import android.view.View
import android.widget.ProgressBar

fun Int?.orZero(): Int = this ?: 0

fun ProgressBar.visible(){
    this.visibility = View.VISIBLE
}

fun ProgressBar.gone(){
    this.visibility = View.GONE
}
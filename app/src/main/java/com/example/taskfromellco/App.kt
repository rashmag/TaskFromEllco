package com.example.taskfromellco

import android.app.Application
import com.example.taskfromellco.di.app.DaggerAppComponent

class App :Application() {
    val component = DaggerAppComponent.factory().create(this)
}
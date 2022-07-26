package com.example.taskfromellco.di.lenta

import com.example.taskfromellco.presentation.lenta.LentaFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface LentaComp {

    fun inject(lentaFragment: LentaFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():LentaComp
    }
}
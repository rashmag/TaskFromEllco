package com.example.taskfromellco.di.list

import com.example.taskfromellco.presentation.list.ListFragment
import dagger.Subcomponent

@Subcomponent
interface ListComp {

    fun inject(listFragment: ListFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():ListComp
    }
}
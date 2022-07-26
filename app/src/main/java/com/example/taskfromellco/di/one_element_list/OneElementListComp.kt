package com.example.taskfromellco.di.one_element_list

import com.example.taskfromellco.presentation.list.ListFragment
import com.example.taskfromellco.presentation.one_element_list.OneElementListFragment
import dagger.Subcomponent

@Subcomponent
interface OneElementListComp {

    fun inject(oneElementListFragment: OneElementListFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():OneElementListComp
    }
}
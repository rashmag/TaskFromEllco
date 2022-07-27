package com.example.taskfromellco.di.one_element_list

import com.example.taskfromellco.presentation.one_element.OneElementFragment
import dagger.Subcomponent

@Subcomponent
interface OneElementListComp {

    fun inject(oneElementFragment: OneElementFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():OneElementListComp
    }
}
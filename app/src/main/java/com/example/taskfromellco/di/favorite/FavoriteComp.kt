package com.example.taskfromellco.di.favorite

import com.example.taskfromellco.presentation.favorite.FavoriteFragment
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent
interface FavoriteComp {

    fun inject(favoriteFragment: FavoriteFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():FavoriteComp
    }
}
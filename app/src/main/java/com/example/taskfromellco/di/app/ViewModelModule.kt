package com.example.taskfromellco.di.app

import androidx.lifecycle.ViewModel
import com.example.mydsu.di.scopes.ViewModelKey
import com.example.taskfromellco.presentation.favorite.FavoriteViewModel
import com.example.taskfromellco.presentation.lenta.LentaViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @IntoMap
    @ViewModelKey(FavoriteViewModel::class)
    @Binds
    fun bindFavoriteViewModel(favoriteViewModel: FavoriteViewModel):ViewModel

    @IntoMap
    @ViewModelKey(LentaViewModel::class)
    @Binds
    fun bindLentaViewModel(lentaViewModel: LentaViewModel):ViewModel
}
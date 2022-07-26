package com.example.taskfromellco.di.app

import android.app.Application
import com.example.taskfromellco.di.favorite.FavoriteComp
import com.example.taskfromellco.di.lenta.LentaComp
import com.example.taskfromellco.di.list.ListComp
import com.example.taskfromellco.di.one_element_list.OneElementListComp
import com.example.taskfromellco.utils.AppScope
import dagger.Binds
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [AppModule::class,ViewModelModule::class])
interface AppComponent {

    fun favoriteComp(): FavoriteComp.Factory
    fun lentaComp(): LentaComp.Factory
    fun listComp(): ListComp.Factory
    fun oneElementListComp(): OneElementListComp.Factory

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }
}
package com.example.taskfromellco.di.app

import com.example.taskfromellco.data.local_db.DataRepImpl
import com.example.taskfromellco.domain.repository.DataRep
import dagger.Binds
import dagger.Module

@Module
interface AppModule {
    @Binds
    fun bindDataRep(dataRepImpl: DataRepImpl):DataRep
}
package com.example.taskfromellco.domain.usecase

import com.example.taskfromellco.data.local_db.DataRepImpl
import com.example.taskfromellco.domain.model.ArticalDomainModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock


class LoadDataUseCaseTest {
    @Test
    suspend fun `should return list artical model`(){
//        @Mock
//        lateinit var dataRep = DataRepImpl()
        val dataRep = mock<DataRepImpl>()

        val list = listOf<ArticalDomainModel>()

        Mockito.`when`(dataRep.loadData()).thenReturn(list)
        val loadData = LoadDataUseCase(dataRep = dataRep)
        val actual = loadData.invoke()

        val expected = list

        Assertions.assertEquals(expected,actual)
    }
}
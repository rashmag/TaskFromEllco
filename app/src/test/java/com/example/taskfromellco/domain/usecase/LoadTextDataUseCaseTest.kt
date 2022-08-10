package com.example.taskfromellco.domain.usecase

import com.example.taskfromellco.data.local_db.DataRepImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class LoadTextDataUseCaseTest{
    @Test
    fun `text ansalta`(){

        val dataRep = mock<DataRepImpl>()

        val list = "test2"

        Mockito.`when`(dataRep.loadText()).thenReturn(list)
        val loadData = LoadTextDataUseCase(dataRep = dataRep)
        val actual = loadData.invoke()

        val expected = "test2"

        Assertions.assertEquals(expected,actual)
    }
}
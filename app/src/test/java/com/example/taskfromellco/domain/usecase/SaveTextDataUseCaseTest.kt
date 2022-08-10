package com.example.taskfromellco.domain.usecase

import com.example.taskfromellco.data.local_db.DataRepImpl
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class SaveTextDataUseCaseTest{
    @Test
    fun `sould save data`(){

        val dataRep = mock<DataRepImpl>()

        Mockito.`when`(dataRep.loadText()).thenReturn("test")
        val saveData = SaveTextDataUseCase(dataRep = dataRep)

        val actual = saveData.invoke("test")

        val expected = true

        Assertions.assertEquals(expected,actual)
    }
}
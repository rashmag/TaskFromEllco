package com.example.taskfromellco.data.local_db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import androidx.test.platform.app.InstrumentationRegistry
import com.example.taskfromellco.util.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.jupiter.api.Assertions
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class MainDaoTest {


    //InstantTaskExecutorRule() - нужно использовать, чтобы ваши обновления LiveData выполнялись синхронно.
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var dataBase: MainDataBase
    private lateinit var dao: MainDao

    @Before
    fun before() {
//        inMemoryDatabaseBuilder() - она означает что база дыннах будет только в оперативной памяти, то есть не на постоянной
        dataBase = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getInstrumentation().targetContext,
            MainDataBase::class.java
        ).allowMainThreadQueries().build()
        dao = dataBase.mainDao()
    }

    @After
    fun after() {
        dataBase.close()
    }

    @Test
    fun saveValue() = runBlockingTest {
        val mainModelEntity = MainModelEntity(1,"author","content","description",
            "published","title","url","urlToImage",true)
        dao.saveValue(mainModelEntity)

        val allMainItems = dao.getAllData().getOrAwaitValue()

        Assertions.assertEquals(mainModelEntity,allMainItems.first())
    }

    @Test
    fun deleteMainItem() = runBlockingTest {
        val mainModelEntity = MainModelEntity(1,"author","content","description",
            "published","title","url","urlToImage",true)
        dao.saveValue(mainModelEntity) // сначала же нужно добавить, потому что БД очищается в @After
        dao.deleteUser(mainModelEntity)

        val allMainItems = dao.getAllData().getOrAwaitValue()

        Assertions.assertNotEquals(allMainItems,mainModelEntity)
    }

}
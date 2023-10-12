package com.agro.junittestingapp

import androidx.room.Room

import androidx.test.core.app.ApplicationProvider
import com.agro.junittestingapp.database.Quote
import com.agro.junittestingapp.database.QuoteDataBase
import com.agro.junittestingapp.database.QuotesDao
import kotlinx.coroutines.runBlocking


import org.junit.*



class QuotesDaoTest {

//    @get:Rule
//    val instantExecutorRules= InstantTaskExecutorRule()



    lateinit var quotesDao: QuotesDao
    lateinit var quoteDataBase: QuoteDataBase


    @Before
    fun setUp() {
        quoteDataBase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            QuoteDataBase::class.java
        ).allowMainThreadQueries().build()

    }

    @Test
    fun insertQuote_expectedSingleQuote() = runBlocking{
        val quote =Quote(0,"this is test quote","Rajesh quote")
        quotesDao.insertQuote(quote)

        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(1,result.size)
        Assert.assertEquals("This is a quote",result[0].text)
    }
  @Test
    fun deleteQuote_expectedNoResults() = runBlocking{
        val quote =Quote(0,"This is test quote","Rajesh quote")
        quotesDao.insertQuote(quote)
        quotesDao.delete()

        val result = quotesDao.getQuotes().getOrAwaitValue()
        Assert.assertEquals(0,result.size)
        Assert.assertEquals("This is a quote",result[0].text)
    }

    @After
    fun tearDown() {
        quoteDataBase.close()
    }
}
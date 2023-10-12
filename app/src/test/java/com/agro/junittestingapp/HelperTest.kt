package com.agro.taprichhapriapp.utills

import org.junit.After
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class  HelperTest {
   lateinit var helper:Helper
    @Before
    fun setUp(){
        helper =Helper()
        println("Before every test case")
    }
    @After
    fun tearDown(){
        println("After every test case")
    }
    @Test
    fun isPallindrome() {
        //Arrange

        //Act
        val result =helper.isPallindrome("hello")
        //Assert
        assertEquals(false,result)
    }
    @Test
    fun isPallindrome_inputString_level_expectedTrue() {
        //Arrange
        val helper=Helper()
        //Act
        val result =helper.isPallindrome("level")
        //Assert
        assertEquals(true,result)
    }
}
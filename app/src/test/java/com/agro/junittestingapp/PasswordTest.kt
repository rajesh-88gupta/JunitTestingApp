package com.agro.taprichhapriapp.utills

import org.junit.Assert
import org.junit.Test

class PasswordTest {

    @Test
    fun validPassword_blankInput_expectedRequiredField(){
        val sut = Helper()
        val result  =sut.validPassword(" ")
        Assert.assertEquals("Password is required field",result)
    }

}
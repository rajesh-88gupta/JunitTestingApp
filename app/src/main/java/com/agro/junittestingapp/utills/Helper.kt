package com.agro.taprichhapriapp.utills

class Helper {
    fun isPallindrome(input :String):Boolean{
        var i=0
        var j =input.length-1
        var result =true
        while (i< j){
            if(input[i]!=input[j]){
                result =false
                break
            }
            i++
            j--

        }

        return result
    }
    fun validPassword(input: String) = when {
        input.isBlank()-> {
            "Password is required field"
        }
        input.length < 6 ->{
            "Length of Password should be greater then 6"
        }
        input.length < 15 ->{
            "Length of Password should be less then then 15"
        }else ->{
            "valid"
        }

    }
}
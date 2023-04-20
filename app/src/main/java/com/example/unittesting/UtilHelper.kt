package com.example.unittesting

class UtilHelper {


    fun validatePassword(password:String): String {
        return if (password.isBlank()){
            "invalid"
        }else if (password.length<6 || password.length>15){
            "invalid"
        }else "valid"


    }

    fun reverseString(input:String?): String {

        if (input==null){
            throw IllegalArgumentException("Null Not Allowed")
        }
        val start=0
        var end = input.length

        val str = input.split("")
        var temp = ""
        /*for (i in str.indices.reversed()) {
            temp= temp+str[i]
        }*/
       while (start<=end){
           temp= temp+str[end]
           end--
       }

        return temp
    }

}
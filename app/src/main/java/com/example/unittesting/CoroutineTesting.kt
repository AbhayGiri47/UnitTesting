package com.example.unittesting

import kotlinx.coroutines.*

class CoroutineTesting(val dispatcher: CoroutineDispatcher) {

    suspend fun getUser():String{
        delay(10000)
        return "Abhay"
    }

    suspend fun getUserName():String{

        CoroutineScope(dispatcher).launch {
            delay(2000)
        }
        return "User - ABhay"
    }

    suspend fun getAddress():String{

        withContext(dispatcher) {
            delay(2000)
        }
        return "Address - ABhay"
    }

    var globalarg=false
    suspend fun getAddressDetail(){

        CoroutineScope(dispatcher).launch {
            globalarg = true
        }
    }


}
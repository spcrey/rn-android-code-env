package com.rnandroid.test

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object CoroutinesTest {
    @JvmStatic
    fun main(args: Array<String>): Unit = runBlocking {
        val scope = MainScope()
        val job = scope.launch(Dispatchers.IO) {
            println("Coroutines Start")
            delay(2000)
            println("Coroutines End")
        }
        job.join()
    }
}


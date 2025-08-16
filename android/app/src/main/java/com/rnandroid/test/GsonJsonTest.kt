package com.rnandroid.test

import com.google.gson.Gson
import com.google.gson.JsonObject

object GsonJsonTest {
    val gson = Gson()

    interface ObjectPack<T> {
        fun packToString(): String
    }

    interface ObjectUnpack<T> {
        fun unpackFromString(packString: String): T
    }

    data class Person(
        val name: String? = null,
        val age: Int? = null,
    ) : ObjectPack<Person> {
        override fun packToString(): String {
            val jsonString = gson.toJson(this)
            println("Step1: Object to JsonString")
            val packJson = JsonObject().apply {
                addProperty("data", jsonString)
            }
            println("Step2: JsonString to PackJson")
            val packString = gson.toJson(packJson)
            println("Step3: PackJson tTo PackString")
            return packString
        }
    }

    interface Builder<T> {
        fun build(): T?
    }

    class PersonBuilder : ObjectUnpack<Person>, Builder<Person> {
        var packString: String? = null

        override fun unpackFromString(packString: String): Person {
            val packJson = gson.fromJson(packString, JsonObject::class.java)
            println("Step1: PackString to PackJson")
            val escapeJsonString = packJson.get("data")
            println("Step2: PackJson to EscapeJsonString")
            val jsonString = gson.fromJson(escapeJsonString, String::class.java)
            println("Step3: EscapeJsonString to JsonString")
            val person = gson.fromJson(jsonString, Person::class.java)
            println("Step4: JsonString to Object")
            return person
        }

        fun setPackString(packString: String): PersonBuilder {
            this.packString = packString
            return this
        }

        override fun build(): Person? {
            return packString?.let {
                unpackFromString(it)
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println("Hello, GsonJson!")
        val person = Person("Crey", 13)
        val packData = person.packToString()
        println("Pack Data: $packData")
        val unpackData = PersonBuilder()
            .setPackString(packData)
            .build()
        println("Unpack Data: $unpackData")
    }
}
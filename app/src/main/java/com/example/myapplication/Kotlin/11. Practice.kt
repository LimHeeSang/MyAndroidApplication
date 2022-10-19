package com.example.myapplication.Kotlin

// 11. 제어흐름 실습

fun main(args:Array<String>){

    val value : Int? = null

    when(value){
        null -> println("value is null")
        else -> println("value is not null")
    }

    val value2: Boolean? = null

    when (value2){
        true -> {
        }
        false ->{
        }
        null ->{
        }
    }

    val value3 = when(value2){
        true -> 1
        false -> 3
        else -> 4
    }


    // when의 다양한 조건식(1)
    val value4: Int = 10
    when(value4){
        is Int ->{
            println("value4 is int")
        }
        else ->{
            println("value4 is not int")
        }
    }

    // when의 다양한 조건식(2)
    val value5: Int = 87
    when (value5){
        in 60..70 -> {
            println("value is in 60~70")
        }
        in 70..80 -> {
            println("value is in 70~80")
        }
        in 80..90 -> {
            println("value is in 80~90")
        }
    }
}
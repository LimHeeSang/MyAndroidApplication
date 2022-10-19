package com.example.myapplication.Kotlin

// 16. Iterable

fun main(array:Array<String>){

    val a = mutableListOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9)

    // 반복하는 방법(1)
    for (item in a ){
        if(item == 5){
            println("item is Five")
        }else{
            println("item is not Five")
        }
    }
    println()

    // 반복하는 방법(2)
    for((index, item) in a.withIndex()){
        println("index: " + index + "value; " + item)
    }
    // 문자열 + Int(정수) = 문자열
    // 문자열 + 아무거나 = 문자열

    // 반복하는 방법(3)
    a.forEach{
        println(it)
    }
    // 반복하는 방법(4)
    a.forEach{ item ->
        println(item)
    }
    // 반복하는 방법(5)
    a.forEachIndexed{ index, item ->
        println("index: " + index + "value; " + item)
    }

    //반복하는 방법 (6)
    for(i in 0 until a.size){
        // until은 마지막을 포함하지 않는다
        println(a.get(i))
    }

    // 반복하는 방법 (7)
    for (i in 0 until a.size step(2)){
        println(a.get(i))
    }

    // 반복하는 방법 (8)
    for(i in a.size-1 downTo(0)){
        println(a.get(i))
    }

    // 반복하는 방법 (9)
    for(i in a.size-1 downTo(0) step(2)){
        println(a.get(i))
    }

    // 반복하는 방법 (10)
    for(i in 0..10){
        println(i)
    }

    // 반복하는 방법 (11)
    var b = 0
    var c = 4

    while(b < c){
        b++
        println("b")
    }

    var d = 0
    var e = 4
    println()
    // 반복하는 방법(12)
    do{
        println("hello")
        d++
    }while(d < e)



}
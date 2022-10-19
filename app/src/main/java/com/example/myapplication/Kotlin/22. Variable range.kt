package com.example.myapplication.Kotlin

// 변수의 접근 범위
// 1. 전역 변수
// 2. 지역 변수



var number100: Int = 10

fun main(array:Array<String>){

    println(number100)

    val test = Test("홍길동")
    test.name
}

class Test(var name:String){

    fun testFun(){
        var birth: String = "2000/3/1"
        name = "홍길동"
        number100 = 100

        fun testFun3(){
            var genger: String = "male"
        }
    }
    fun testFun2(){
        name = "홍길동"
    }
}
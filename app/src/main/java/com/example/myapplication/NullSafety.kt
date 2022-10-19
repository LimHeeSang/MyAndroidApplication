package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class NullSafety : AppCompatActivity() {

    /*lateinit var lateCar : Int
        lateinit 선언한 변수를 초기화 하기전에 사용해버리면 에러발생
    class  Car(var number: Int){
    }*/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_null_safety)

        val number : Int = 10
        val number1 : Int? = null

        // !! -> 개발자가 null이 아님을 보장
        val number5 : Int = number1!! + 10

        //val number3 = number? + number1
        val number3 = number1?.plus(number)
        Log.d("number", "number3: " +number3)

        //삼항연산자 -> 엘비스 연산자(?:)
        val number4 = number1 ?: 10     //number4에 number1이 null이면 10이 null이 아니면 number1이 들어간다

        /*lateCar = Car(10)
        Log.d("number", "late number" + late.number)*/

    }

    fun plus(a:Int, b: Int?): Int{
        if(b != null) return a + b
        else return a
    }
    fun plus2(a : Int, b: Int?): Int?{
        return b?.plus(a)
    }
}
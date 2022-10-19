package com.example.myapplication.Kotlin

// 두번까지 봐준다
// 두번이상 넘어가면 리팩토링 해라

// 25. 상속
// 부모로부터 설명서를 물려받는다!

fun main(array:Array<String>){
    val superCar100: SuperCar100 = SuperCar100()
    superCar100.drive()
    superCar100.stop()


}

open class Car100(){
    open fun drive(){

    }
    fun stop(){

    }
}

//오버라이드
class SuperCar100(): Car100(){
    override fun drive() {
        super.drive()
        println("빨리 달린다")
    }
}

class Bus100(): Car100(){

}
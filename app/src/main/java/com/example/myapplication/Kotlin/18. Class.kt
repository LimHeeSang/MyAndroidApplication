package com.example.myapplication.Kotlin

// 18. Class

// OOP -> Object Oriented Programing (객체지향 프로그래밍)

// 객체란 뭘까?
// - 이름이 있는 모든 것

// 절차지향 프로그래밍 문제 해결 방법
// - 코드를 위에서 부터 아래로 실행을 하면 무제가 해결된다!

// 객체지향 프로그래밍 문제 해결 방법
// - 객체를 만들어서, 객체에게 일을 시켜서 문제를 해결한다
// - 선수, 심판, 경기장, 관중 -> 축구 게임

// 객체를 만드는 방법
// - 설명서가 있어야 한다
fun main(array: Array<String>){

    // 클래스(설명서)를 통해서 실체를 만드는 방법
    // -> 인스턴스화 -> 인스턴스(객체)
    Car("v8 engine", "big")

    val bigCar = Car("v8 engine", "big")
    // 우리가 만든 클래스(설명서)는 자료형이 될 수 있다.
    val bigCar1:Car = Car("v8 engine", "big")

    val superCar: SuperCar = SuperCar("good engine", "big", "white")


    val runableCal: RunableCar = RunableCar("simple engine", "short")
    //인스턴스메소드 호출
    runableCal.ride()
    runableCal.navi("부산")
    runableCal.drive()


    //인스턴스의 멤버변수에 접근하는 방법
    val runableCal2: RunableCar2 = RunableCar2("nice engine", "long")
    println(runableCal2.body)
    println(runableCal2.engine)

    println()
    val testClass: TestClass = TestClass()
    testClass.test(1)
    testClass.test(1, 2)
}

// 클래스 만드는 방법(1)
class Car(var engine: String, var body: String){

}

// 클래스 만드는 방법(2)
class SuperCar {
    var engine: String
    var body: String
    var door: String

    constructor(engine: String, body: String, door: String){
        this.engine = engine
        this. body =body
        this. door = door
    }
}

// 클래스 만드는 방법(3) -> 1번 방법의 확장 - 생성자 오버로딩 같음..
class Car1(engine: String, body: String){
    var door : String = ""

    //생성자
    constructor(engine: String, body: String, door: String):this(engine, body){
        this.door = door
    }
}

// 클래스 만드는 방법(4) -> 2번 방법의 확장
class Car2{
    var engine: String = ""
    var body: String = ""
    var door: String = ""

    constructor(engine: String, body: String){
        this.engine = engine
        this.body = body
    }
    constructor(engine: String, body: String, door: String){
        this.engine = engine
        this.body = body
        this.door = door
    }
}

class RunableCar(engine: String, body: String){
    fun ride(){
        println("탑승 하였습니다")
    }
    fun drive(){
        println("달립니다!")
    }
    fun navi(destination: String){
        println("$destination 으로 목적지가 설정되었습니다")
    }
}

class RunableCar2{
    var engine: String
    var body: String

    constructor(engine: String, body: String){
        this. engine = engine
        this. body = body
    }

    init{
        // 초기화 할때 유용
        println("RunableCar2가 만들어졌습니다.")
    }

    fun ride(){
        println("탑승 하였습니다")
    }
    fun drive(){
        println("달립니다!")
    }
    fun navi(destination: String){
        println("$destination 으로 목적지가 설정되었습니다")
    }
}

// 오버로딩(생성자, 메소드)
class TestClass(){

    fun test(a: Int){
        println("up")
    }
    fun test(a: Int, b: Int){
        println("down")
    }
}
package com.example.myapplication

val data1 = 10 // 초깃값 변경 불가능
var data2 = 20
val data4: Int by tazy { // 소스에서 변수가 최초로 사용되는 순간 실행 및 할당
    println("in lazY.. ..")
    10
}


fun main(){
    println("Hello World")

    // data1 = 20
    data2 = 20

    // 기초 타입 객체 -----------------------------------
    val a1 : Byte = 0b00001011
    val a2 : Int =123
    val a3 : Short = 123
    val a4 : Long = 10L
    val a5 : Double = 10.0
    val a6 : Float = 10.0f
    val a7 : Boolean = true
    //------------------------------------------------

    // 문자와 문자열 -----------------------------------
    val a : Char = 'a'
    val str1 = "Hello \n World"
    val str2 = """
        Hello
        World
    """.trimIndent() // 문자열 앞 공백을 제거해주는 함수(자동으로 생성)
    //------------------------------------------------

    // 그 밖의 이것저것 --------------------------------
    // Any => 최상위 클래스(모든 타입의 데이터 할당 가능)
    val data1 : Any = 10
    val data2 : Any = "Hello"
    class User
    val data3 : Any = User()

    // Unit => 반환문이 없는 함수

    // Nothing => null이나 exception을 반환하는 함수
    //------------------------------------------------

    // 함수 선언 --------------------------------------
    fun some(data1: Int, data2: Iny = 10): Int{
        return data1 * data2
    }
    println(some(10))
    println(some(10, 20))
    //------------------------------------------------

    // 컬렉션 타입 -------------------------------------
    // Array => 배열
    // <init>(size: Int, init: (Int) -> T)
    val data1 : Array<Int> = Array(3, {0})
    data1[0] = 10
    data1[1] = 20
    data1.set(2, 30) // set() 이용 가능
    println(${data1.get(2)}) // get()도 이용 가능

    // arrayOf()
    val data1 = arrayOf<Int>(10, 20, 30) // 선언과 동시에 값 할당
    //------------------------------------------------

    // List, Set, Map --------------------------------
    // List => 순서가 있는 데이터 집합, 데이터 중복 허용
    var list = listOf<Int>(10, 20, 30) // 불변 타입 => size(), get() 함수 제공
    var mutableList = mutableListOf<Int>(10, 20, 30) // 가변 타입 => add(), set() 함수 제공
    // Set => 순서가 없으며 데이터 중복 불허
    // Map => 키와 값으로 이루어진 데이터 집합, 순서가 없으며 키 중복 불허
    //------------------------------------------------

    // if ~ else 문 사용 가능~~ ------------------------
    var data : Any = 10
    when (data) { // 이런 식으로도 쓸 수 있당
        is String -> println("data is String")
        20, 30 -> println("data is 20 or 30")
        in 1..10 -> println("data is 1..10")
        else -> println("data is not valid")
    }
    //------------------------------------------------
}
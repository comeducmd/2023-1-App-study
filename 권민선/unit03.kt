package com.example.unit_study

import java.security.KeyStore.TrustedCertificateEntry

/* -------변수 초기화 미루기--------- */
//lateinit: var 만 사용 가능, 기본 타입(ex int, double...)은 사용 불가
lateinit var late_str: String
//by lazy {}: 최초 이용되는 순간 {}부분 자동 실행, 마지막 줄의 결과가 변수의 초기값
val lazy_str: Int by lazy{
    println("do lazy...")
    10+20
}

fun main(){
    println("lazy_str result: $lazy_str")

    /* --------변수 선언 ---------- */
    /*val: 변경 불가 변수 vs var: 변경 가능 변수*/
    val data1=10 //이후 변경 불가
    var data2=20 //이후 변경 가능
    println("var data2 before: $data2")
    data2=22
    println("var data2 after: $data2")

    /*타입 지정*/
    //변수 명 뒤에 :을 추가해 타입 명시
    var data3: Int = 30
    var data4 = 40  //이처럼 타입 유추 가능하면 생락 가능

    /*널 허용 vs 불허용*/
    val b1: Int    //널 불허용
    val b2: String? =null  //타입 뒤에 ? 붙이면 널 허용!

    /*--------데이터 타입----------*/
    //1) 기초 타입 객체
    val a1: Byte = 0b001011
    val a2: Int = 24
    val a3: Short = 10
    val a4: Long = 102030405056
    val a5: Double = 23.45678
    val a6: Float= 23.4F
    val a7: Boolean = false //대문자(False)로 하면 안됨
    val a8: Char ='z'   //코틀린char는 숫자랑 호환 안됨

    //2) 문자열 객체
    val a9: String ="hello \tkotlin"
    val a10: String ="hello $a8!"   //string에 변수 포함할 떄는 $(문자열 템플릿)사용
    println("$a10")

    //3) 모든 타입 커버 가능 객체
    val a11: Any = "put anything"

    //4) 특수 상황 표현 객체 -> 함수와 함께 사용
    var a12: Unit
    val a13: Nothing

    //5) 컬랙션 타입
    //5-1) array
    val a14: Array<Int> = Array(3,{1})  //각각 초기화는 불가. 하나로 통일해라
    println("array size: ${a14.size}")
    println("array data14: ${a14[0]},${a14[1]},${a14.get(2)}")
    //배열 데이터가 기초 타입이라면 다른 방식으로 선언도 가능
    val a15: DoubleArray = DoubleArray(3,{1.1})
    println("array data15: ${a15[0]},${a15[1]},${a15.get(2)}")

    //위와 같은 방법은 요소마다 다른 값을 할당하진 못한다.
    //선언과 동시에 할당하고 싶다면(기초타입만 가능)
    val a16=arrayOf<Int>(1,2,3)
    println("array data16: ${a16[0]},${a16[1]},${a16.get(2)}")
    //근데 실제로 해보니 String타입도 되는데용
    val a17=arrayOf<String>("Hi","how","are","you")
    println("array data17: ${a17[0]},${a17[1]},${a17.get(2)},${a17.get(3)}")

    //5-2,3,4) list,set,map
    //가변타입, 불변타입(앞에 mutable붙임)이 나누어져 있다
    var list1 = listOf<Int>(100,200,300)
    var mutablelist = mutableListOf<Int>(400,500)
    mutablelist.add(2,600)
    mutablelist.set(0,100)
    println("\nmutable list: ${mutablelist[0]},${mutablelist[1]},${mutablelist[2]}")

    var map = mapOf<Int,String>(Pair(1,"First"),2 to "Two",Pair(10,"Ten"))
    println("map data: ${map.get(1)}, ${map.get(2)}, ${map.get(10)}")

    /*-----------조건문----------*/
    println("\n조건문 파트")
    var num1=10

    //1) if ~ else
    if (num1<10) {
        println("num1<10")
    }
    else if (num1>=10 && num1<=20){
        println("10<= num1 <=20")
    }
    else{
        println("num1>20")
    }

    //표현식(결과값 반환하는 계산식)으로도 사용 가능
    var isminus1= if(num1>0){
        println("num1 is positive number")
        false
    }
    else if (num1==0) {
        println("num1 is zero")
        false
    }
    else{
        println("num1 is negative number")
        true
    }
    println("num1 is minus?: $isminus1")

    //2) when
    when(num1){
        0 -> println("num1 is 0")
        10 -> println("num1 is 10")
        20 -> println("num1 is 20")
        else -> {
            println("there is no other option")
        }
    }
    //표현식으로 사용 가능. 단 else 생략 불가
    var num2=20
    var isminus2 = when{
        num2 >= 0 -> false
        else -> true

    }
    println("num2 is minus?: $isminus2")

    /*-------반복문-----------*/
    //1) for
    for(i in 1..10){}
    for(i in 1 until 10){}
    for (i in 2..10 step 3) {print("$i ")}
    print("\n")
    for (i in 10 downTo 5){print("$i ")}

    var array2=arrayOf<String>("HI","how","are","you")
    print("\n")
    for (i in array2){
        print("$i ")
    }
    //2) while
    var x=0
    print("\n")
    while(x<5){
        print("$x ")
        x++
    }


    println("\n\n함수 파트")
    println("3번째 인수는 기본값 10으로 설정되어있다")
    println("show_sum(10,20)로 호출한 경우:")
    show_sum(10,20)
    println("show_sum(10,20,30)로 호출한 경우:")
    show_sum(10,20,30)


}

/* --------함수 선언 -------*/
fun show_sum(para1: Int, para2: Int, para3:Int =10){
    //매개변수(para1, para2)는 변경 불가하다 -> val 변수
    print("sum: ${para1+para2+para3}\n")
}
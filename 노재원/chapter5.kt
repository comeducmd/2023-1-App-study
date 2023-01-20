package com.example.myapplication

fun main(){
    // 람다 함수 --------------------------------------
    // 익명함수 : 일반적으로 fun 으로 선언하는 함수와 다르게, { }를 이용해 표현
    val sum = {no1: Int, no2: Int -> no1 + no2} // 선언
    sum(10, 20) // 호출
    {-> println("funcion call")} // 매개변수가 항상 있어야 하는 것은 아님(화살표도 생략 가능)

    // 매개변수가 한 개인 람다 함수에 it 키워드 사용
    // 중괄호 안에 화살표가 없어 매개변수가 없는 것처럼 보이지만,
    // 람다 함수 앞에 (Int) -> Unit이 매개변수가 한 개인 람다 함수임을 알려줌
    // it 키워드를 이용해 해당 매개변수를 이용 가능
    val some: (Int) -> Unit = {println(it)}
    some(10) // 10

    // 람다 함수에서는 return문을 사용할 수 없음
    // 람다 함수의 반환값은 본문에서 마지막 줄의 실행 결과
    val some = {no1 : Int, no2: Int ->
        println("in lambda funtion")
        no1 * no2
    }
    println("result : ${some(10, 20)}") // result : 200
    //------------------------------------------------

    // 함수 타입 --------------------------------------
    // 변수에 함수를 대입하기 위해서는 변수를 함수 타입으로 선언해야 함
    val some: (Int, Int) -> Int = {no1: Int, no2: Int -> no1 + no2}
    //        (    함수 타입    )   (           함수 내용           )
    //------------------------------------------------

    // 타입 별칭 --------------------------------------
    typealias MyFunType = (Int, Int) -> Boolean
    fun main() {
        val someFun: MyFunType = {no1 : Int, no2: Int -> no1 > no2}
    }
    println(someFun(10, 20)) // false
    println(someFun(20, 10)) // true

    // 매개변수 타입 생략
    typealias MyFunType = (Int, Int) -> Boolean
    fun main() {
        // 변수 정의에서 (Int, Int) -> Boolean이라고 정의한 것처럼,
        // 타입을 명시하지 않아도 그것을 유추할 수 있을 때는
        // 매개변수의 타입을 생략할 수 있음
        val someFun: MyFunType = {no1, no2 -> no1 > no2}
    }
    //------------------------------------------------

    // 고차 함수 --------------------------------------
    // 고차 함수 : 함수를 매개변수로 전달받거나 반환하는 함수
    fun hofFun(arg: (Int) -> Boolean): () -> String { // 매개변수를 하나 선언했지만 타입이 함수
        val result = if(arg(10)) {
            "valid"
        } else {
            "invalid"
        }
        return {"hofFun result : $result"}
    }
    fun main() {
        val result = hofFun({no -> no > 0})
        println(result()) // hofFun result : valid
    }
    //------------------------------------------------

    // 널 안정성 --------------------------------------
    // 널(null) : 객체가 선언되었지만 초기화되지 않은 상태(객체가 주소를 가지지 못한 상태)
    val data1: String = "hello" // 변수에 "hello"라는 문자열이 저장된 주소가 대입된 상태
    val data2: String? = null // 변수가 선언되었지만 주솟값이 없어 이용할 수 없는 상태

    // 널인 상태의 객체를 이용하면 널 포인트 예외가 발생
    // 널 안정성 : 널 포인트 예외가 발생하지 않도록 코드를 작성하는 작업
    // ex) 널 안정성을 개발자가 고려한 코드 -> 객체가 널인지 일일이 점검해야 함
    fun main() {
        var data: String? = null // 널 선언
        val length = if (data == null) { // 널 포인트 예외가 발생
            0 // 0 반환
        } else {
            data.length
        }
        println("data length : $length") // data length : 0
    }

    // ex) 코틀린이 제공하는 널 안정성 연산자를 이용한 코드
    // 객체가 널인 상황에서 널 포인터 예외가 발생하지 않도록
    // 프로그래밍 언어가 연산자를 비롯한 여러 기법을 제공
    fun main() {
        var dta: String? = null
        println("data length : ${data?.length ?: 0}") // data length : 0
    }

    // 널 허용 ? 연산자 --------------------------------
    var data1: String = "kkang" // 널 불허
    data1 = null // 오류

    var data2: String? = "kkang" // 널 허용
    data2 = null // 성공

    // 널 안정성 호출 ?. 연산자 -------------------------
    // 널 허용으로 선언한 변수의 멤버에 접근할 때는 반드시 ?. 연산자를 이용해야 함
    // 변수가 널이 아니면 멤버에 접근, 널이면 널을 반환
    var data: String? = "kkang"
    var length = data.length // 오류
    var length = data?.length // 성공

    // 엘비스 ?: 연산자 --------------------------------
    // 변수가 널일 때 대입해야 하는 값이나 실행해야 하는 구문이 있을 때 이용
    fun main() {
        var data: String? = "kkang"
        println("data = $data : ${data?.length ?: -1}") // data = kkang : 5
        data = null
        println("data = $data : ${data?.length ?: -1}") // data = numm : -1
    }

    // 예외 발생 !! 연산자
    // 객체가 널일 때 예외를 일으키는 연산자
    // 널 포인트 예외를 발생시켜야 하는 경우에 이용
    fun some(data: String?): Int {
        return data!!.length
    }
        fun main() {
            println(some(" kkang"))
            println(some(null))
        }
    //------------------------------------------------
}
val data1: Int = 10 //val --> data change x
var data2 = 10 //var --> data change o

//최상위 변수는 선언과 동시에 초기값 할당 해주어야 함.

lateinit var data4: String // 그러나 lateinit로 선언하면 이후에 초기값 할당해도 됨. 단, var만 사용가능 및 (아마? 숫자형 자료에는 사용 불가)
val data5: Int by lazy{
    println("in lazy......")
    10
//by lazy로 작성하면 그 변수를 처음으로 사용하는 순간 중괄호 자동실행 --> 마지막줄의 실행결과가 변수의 초기 값이 됨.
}

fun main() {
    //data1 = 20 val --> data change x
    data2 = 20

    val data3: Int //단순 선언

    println("Hello World")

    data3 = 10 //사용하기 위해 값 선언

    println("data3 : $data3")

    println("data5 : $data5")

    var data6: Int? = null //객체이기 때문에 null 대입 가능(뭔소린지 모르겠) --> null은 선언만(메모리는 할당을 안한 상태)
    println("data6 : $data6")

    var data7 = 10
    data7+=10 //이것도 됨
    data7=data7.plus(15)//이건 왜 이렇게 쓰는걸까요
    println("data7 : $data7")

    val str1 = "Hello \n world" //--> 큰 따옴표 하나만 쓴다면 이스케이프 시퀀스로 표현 가능

    var str2 = """              
        Hello
        hi
    """ //--> 큰 따옴표 세개 쓴다면 키보드 입력 그대로 표현 가능

    println("str1: $str1")

    println("str2: $str2")

    //data type 종류
    val a1: Byte = 0b00001011 //2진수
    val a2: Int  = 123 //정수
    val a3: Short = 123//정수
    val a4: Long = 123//정수
    val a5: Double = 10.0 //실수
    val a6: Float = 10.0f//실수
    val a7: Boolean = true // T / F

    //char
    val a8: Char = 'a' //문자
    val str3 = "Hello \n world"

    val data8: Any = 10 
    val data9: Any = "hello" //Any는 최상위, 모든 타입 데이터 할당 가능.

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    println(array())
    println(listsetmap())
}

//반환타입 없는 경우
fun prac(): Unit{

    println(10+20)
    //Unit : 함수의 반환이 없음을 드러냄.
    val data9: Nothing? = null //nothing으로 선언하면 null만 대입 가능. 항상 null 반환하는 함수 등에서 쓰임 즉 unit, nothing모두 특수한 상황에서 쓰임.

    //null 허용과 불허용
    var data10: Int = 10
    // data10 = null -->불허용(불가능)

    var data11: Int? = 10
    data11 = null //-->허용
}

//반환타입 있는 경우
fun defunc1(data11: Int): Int {
    //data12 = 3000 -->불가능. 자동으로 val이(변경 불가능) 적용됨
    return data11 * 10
}

fun defunc2(data12: Int, data13: Int):Int{
    return data12 * data13

}

fun array() {
    println(defunc2(10, 20)) //83번째 함수 실행, 순서대로 매개변수에 들어감.

    defunc2(data13 = 30, data12= 10) // 명명된 매개변수(지정해서 호출) 가능.

    val data14: Array<Int> = Array(3,{0}) //첫번째 인자: 배열 크기. 두 번째 인자 배열 초깃값. 즉 0,0,0

    //배열 값 변경 근데 val로 선언했는데 왜 바뀔 수 있을까
    data14[0] = 10
    data14[1] = 20
    data14.set(2,30)

    println("""
    array size : ${data14.size}

    array data : ${data14[0]}, ${data14[1]}, ${data14.get(2)}  
    """)

    val data15: IntArray = IntArray(3,{ 0 }) //클래스 명시
    val data16: BooleanArray = BooleanArray(3,{ false })

    val data17 = arrayOf<Int>(10,20,30)
    println("""
    array size : ${data17.size}

    array data : ${data17[0]}, ${data17[1]}, ${data17.get(2)}  
    """)
}

fun listsetmap() {
    println("List : listOf는 불변, 순서있고 중복 가능, mutableListOf는 가변")
    println("Set : setOf는 불변, 순서 없고 중복 허용 안함, mutableSetOf는 가변")
    println("Map :mapOf는 불변, 키와 값으로 키 중복은 허용 안함, mutableMapOf는 가변")//파이썬 딕셔너리

    var list = listOf<Int>(10,20,30)

    var mutableList = mutableListOf<Int>(10,20,30)
    mutableList.add(3, 40)
    mutableList.add(0, 50)

    println("""
    list size : ${mutableList.size}

    list data : ${mutableList[0]}, ${mutableList[1]}, ${mutableList.get(2)}, ${mutableList.get(3)}
    """)

    var map = mapOf<String, String>(Pair("one", "hello"),"two" to "world") //딕셔너리 처럼.

    println("""
    map size : ${map.size}

    map data : ${map.get("one")}, ${map.get("two")}

    """)

}
//86~98p

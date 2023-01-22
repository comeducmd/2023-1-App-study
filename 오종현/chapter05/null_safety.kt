package chapter05_null_safety

fun main(){
    //flutter와 널세이브티 문법이 약간 다른 느낌임
    var data:String? = null
    println("data length : ${data?.length ?: 0}") // "?:"를 엘비스 연산자라고 한다
    
    //flutter의 data? 는 동일하게 data? 라고 사용하는데
    //flutter의 data! 는 코틀린에서는 data!! 라고 사용합니다.
    //이외 flutter와 구조 동일함
}

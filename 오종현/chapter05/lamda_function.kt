package chapter05_lamda_function


fun main(){
    //원래 함수
    fun lamdaOrifun(counter: Int): Int{
        return counter*2
    }

    //람다 함수
    val lamdafun = {counter:Int -> println(counter)}
    lamdafun(10)
    //매개변수가 하나인 람다 함수라면 it 키워드를 통해 다음과 같이 작성 가능
    val lamdaWithOne: (Int) -> Unit = {println(it)}
    //따라서 람다 함수의 선언은 이런식으로
    val someLamda:(Int, Int) -> Int = {num1: Int, num2: Int -> num1+num2}
    //람다함수 중첩해서 고차함수로 사용가능
    fun highorderFunction(arg:(Int) -> Boolean):() -> String{
        val result = if(arg(10)) {
            "valid"
        } else {
            "invalid"
        }
        return {"hofFun result : $result"}
    }
    val result = highorderFunction({num -> num > 0})
    println(result())

    /*************타입 별칭****************/
    typealias MyFunType = (Int, Int) -> Boolean //fun main() 밖에 선언해야함
    val typeFunc: MyFunType = {num1, num2 -> num1 > num2}
}

fun main(){
    //if 문
    var data =10
    if(data > 10){
        println("data > 10")
    } else if(data>0 && data<=10){
        println("data>0 && data<=10")
    } else{
        println("data <= 0")
    }
    var data1 = 10
    //표현식으로 사용 --> else 생략 불가능.
    var result = if(data1>0){
        println("data > 0")
        true
    } else{
        println("data <= 0")
        false
    }
    println(result)

    //when -->c switch, case 같은 느낌? --> 더 기능 많은 듯.
    var data2: Any = 20
    when (data2) {

        is String -> println("data type is String") //문자열 타입인지. --> is는 타입 확인 연산자

        10 -> println("data2 is 10")

        20,50 -> println("data2 is 20 or 50")

        in 21..30 -> println("data2 is 21..30") // in은 법위 지정 연산자

        else -> {
            println("not valid data")
        } //생략 불가능.
    }
    var data3 = 10

    var result1 = when {
        data3 <= 0 -> "data is <= 0"
        data3 >100 -> "data is > 100"
        else -> "data is valid"
    }
    println(result1)

    //반복문
    //for
    var sum: Int = 0
    var d_a = arrayOf<Int>(10,20,30)

    for (i in 1..10) {
        sum+=i
    }
    println(sum)
    for(j in 1 until 10) {
        sum-=j
    } //1~9
    println(sum)

    for(k in 2..10 step 3){
        sum+=k
    }// 2~10 3씩
    println(sum)

    for(q in 10 downTo 3 step 2){
        sum-=q
    }//10~3으로 2씩
    println(sum) 

    for(p in d_a.indices){ 
        print(d_a[p])
        if(p !== d_a.size - 1) print(",")// control.kt:73:12: warning: identity equality for arguments of types Int and Int is deprecated --> p를 주로 안 사용한다는 거 인듯

    }//데이터 타입 개수 만큼 반복

    for((index, value)in d_a.withIndex()){ 
        print(value)
        if(index !== d_a.size - 1) print(",") //index와 실제 value 동시에.
    }
    
}
//while
fun wh(args: Array<String>){
    var x=0
    var sum3 = 0
    while(x<10){
        sum3 += ++x
    }
    println(sum3)
}

//99~105p

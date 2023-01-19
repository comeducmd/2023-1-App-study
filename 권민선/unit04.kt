package com.example.unit_study

/*--------클래스 생성자-----*/
//constructor(매개변수: 타입){}로 생성자 선언
//1) 주 생성자
class Student(name: String, age: Int){
    var name:String
    var age: Int

    init{
        println("class Student start")
        //주 생성자의 매개변수는 주 생성자 안에서만(init 안에서만)사용할 수 있다

        //주 생성자의 매개변수를 클래스 변수로 사용하고 싶다면
        //1)
        this.name=name
        this.age=age
        //2) class선언 시 매개변수에 var, val키워드 붙여 선언
    }
    fun info(){
        println("name: $name,  age: $age")
    }

}

//2)보조 생성자
//객체를 다양한 방법으로 생성할 수 있게 해준다
class Client{
    constructor(name:String){
        println("constructor(name:String) given information is name: $name")
    }
    constructor(name:String, num:Int){
        println("constructor(name:String, num:Int) given information is name and num: $name, $num")
    }

}
/*-----클래스와 상속------*/
//상속: 클래스를 선언할 때 다른 클래스를 가지고 와 선언하는 것
//하위 클래스에서는 상위 클래스 멤버를 자유롭게 사용할 수 있다
//상속을 허용하려면 상위 클래스 선언시 open붙여야 한다
open class age_info(age: Int){
    var age: Int

    init{
        this.age=age
    }
    fun age_info(age: Int){
        println("info: $age")
    }
    //오버라이딩: 상위 클래스에 정의된 멤버를 하위 클래스에서 같은 이름으로 다시 선언
    //상위 클래스에서 오버라이딩 허용할 멤버 앞에 open키워드 추가
    open fun info_num(){
        println("one information: age")
    }
}
class name_info(age: Int, name: String): age_info(age){
    var name: String
    init{
        this.name=name
    }
    fun age_name_info(age: Int, name: String){
        println("info: $age, $name")
    }
    //하위 클래스에서는 오버라이딩 할 멤버 앞에 override키워드 추가
    override fun info_num(){
        println("two information: age, name")
    }
}

open class Super(){
    open var data=10
    open fun some(){
        println("i am super some() : $data")
    }
}
/*--------클래스 종류------*/
//1) 데이터 클래스
data class data_class(val name: String, val nickname: String)

//2) 오브젝트 클래스
//=익명 클래스(클래스 이름이 없어서 이후 호출할 수 없음. 선언과 동시에 객체 생성해야 한다)
//object라는 키워드 사용
//뒤에 타입(상위클래스, 인터페이스)도 함께 입력해 선언
val obj= object: Super(){
    override var data=20
    override fun some(){
        println("i am object some() $data")
    }
}

//컴패니언 클래스
//객체생성 없이 클래스 이름으로 특정 멤버에 접근
//companion object키워드로 선언
class companion_class{
    companion object{
        var data=10
        fun some(){
            println("companion object: $data")
        }
    }
}

fun main(){
    val minsun=Student("minsun",22)
    minsun.info()

    val client1=Client("min")
    val client2=Client("min", 14)

    val my_info=name_info(22, "minsun")
    my_info.age_info(22)
    my_info.age_name_info(22,"minsun")
    my_info.info_num()

    print("\n데이터 클래스\n")
    val data1=data_class("minsun","cripton02")
    val data2=data_class("minsun","cripton02")
    //객체 의 주 생성자 멤버변수가 동일한지 판별해주는 매서드 .equals
    println("data1 and data2 equal? ${data1.equals(data2)}")

    print("\n오브젝트 클래스\n")
    obj.data=30
    obj.some()

    print("\n컴패니언 클래스\n")
    companion_class.data=100
    companion_class.some()

}




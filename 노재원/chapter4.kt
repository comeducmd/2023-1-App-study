package com.example.myapplication

fun main(){
    // 클래스 선언 ------------------------------------
    class User {
        var name = "NJW"
        constructor(name: String) { // 주 생성자(생략 가능)
            this.name = name
        }
        fun someFun() {
            println("name : $name")
        }
        class SomeClass {} // 클래스 안에 다른 클래스 선언 가능
    }
    //------------------------------------------------

    // 주 생성자 --------------------------------------
    class User(name: String, count: Int) { // 매개변수 넣을 수 있음 => 생성자에서만 사용할 수 있는 지역 변수
        var name: String
        var count: Int

        init{ // init 키워드를 이용해 주 생성자의 본문 구현 가능(객체를 생성할 때 자동으로 실행)
            println("I am init")
            this.name = name // 이렇게 해주면 클래스의 멤버 변수처럼 다른 함수에서 사용 가능
            this.count = count
        }
    }
    fun main() {
        val user = User("NJW", 10)
    }
    //------------------------------------------------

    // 보조 생성자 -------------------------------------
    class User { // constructor 여러 개 추가 가능
        constructor(name: String) {
            println("Constructor(name: String) call...")
        }
        constructor(name: String, count: Int){
            println("Constructor(name: String, count: Int) call...")
        }
    }
    fun main() {
        val user1 = User("NJW")
        val user2 = User("NJW", 10)
    }
    //------------------------------------------------

    // 주 생성자와 보조 생성자 연결 ----------------------
    // 보조 생성자는 객체를 생성할 때 호출되며,
    // 이때 클래스 내에 주 생성자가 있다면 this()를 이용해 주 생성자를 호출해야 함
    // => 어떤 식으로든 주 생성자가 호출되게 해야 함
    class User(name: String) {
        constructor(name: String, count: Int) : this(name) {
            println("1")
        }
    }
    fun main() {
        val user = User("NJW", 10)
    }
    //------------------------------------------------

    // 상속 -------------------------------------------
    open class Super(name: String) {
        var superData = 10
        fun superFun() {
            println("I am superFun : $superData")
        }
    }
    class Sub(name: String): Super(name){ // Super로부터 상속
        constructor(name: String): Super(name){ // 꼭 클래스 선언부에 작성 안 하고 여기에 적어도 됨
        }
    }
    fun main() {
        // overriding => 상위 클래스에 선언된 변수나 함수를 같은 이름으로 하위 클래스에서 다시 선언
        val obj = Sub() // 상속받은 객체를 이용해 함수를 사용
        obj.superData = 20
        obj.superFun()
    }
    //------------------------------------------------

    // 접근 제한자 -------------------------------------
    /*
                      최상위에서 이용                클래스 멤버에서 이용

    public          모든 파일에서 가능               모든 클래스에서 가능
    internal        같은 모듈 내에서 가능            같은 모듈 내에서 가능
    protected       사용 불가                 상속 관계의 하위 클래스에서만 가능
    private         파일 내부에서만 이용             클래스 내부에서만 이용
     */
    //------------------------------------------------

    // 데이터 클래스 -----------------------------------
    class NonDataClass(val name: String, val email: String, val age: Int)
    data class DataClass(val name: String, val email: String, val age: Int)

    fun main() {
        // equals()를 이용해 non1 과 non2 비교시 같지 않다고 나옴
        // => 객체 자체를 비교하기 때문
        val non1 = NonDataClass("NJW", "a@a.com", 10)
        val non2 = NonDataClass("NJW", "a@a.com", 10)

        // equals()를 이용해 data1 과 data2 비교시 같다고 나옴
        // => 각 객체의 데이터를 비교하기 때문
        val data1 = DataClass("NJW", "a@a.com", 10)
        val data2 = DataClass("NJW", "a@a.com", 10)

        println("non data class toString : ${non1.toString()}") // => 이상한 거 나옴(일반 클래스로 생성한 객체의 toString() 함수가 출력하는 값은 의미 있는 데이터가 아님
        println("data class toString : ${data1.toString()}") // => 제대로 나옴(데이터 클래스의 toString() 함수는 객체가 포함하는 멤버 변수의 데이터를 출력함)
    }
    //------------------------------------------------

    // 이 밖에도 ~~ -----------------------------------
    /*
    object class
    companion class
    등등 있음음
     *
    //------------------------------------------------
}
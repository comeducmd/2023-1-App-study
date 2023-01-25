//주 생성자

class Bird(var name: String, var wing: Int, var beak: String, var color: String){
    //초기화 블록
    init {
        println("---------------초기화 시작----------------------")
        println("이름은 $name, 부리는 $beak")
        this.sing(3)
        println("---------------초기화 끝----------------------")
    }
    //메서드
    fun fly()= println("Fly Wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
   
}

fun main(){
    val coco = Bird("my bird",2,"short","blue") //객체 선언과 동시에 초기화 블록 수행

    coco.color = "yellow"
    println("coco.color: ${coco.color}")
    coco.fly()
    coco.sing(3)
}

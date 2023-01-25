open class Bird(var name: String, var wing: Int, var beak: String, var color: String){

    fun fly()= println("Fly Wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")
}

class Lark(name: String, wing: Int, beak: String, color: String) : Bird(name, wing, beak, color){
    fun singHitone( ) = println("Happy song!")
} 
//주생성자 사용헤서 파셍 클래스 선언 -  상위클래스의 매개변수와 인자 지정

class Parrot : Bird {
    val language: String

    constructor(name: String, wing: Int, beak: String, color: String, language: String) : super(name, wing, beak, color){
        this.language = language
    }
    fun speak( ) = println("Speak! $language") 
} 
//부 생성자이용 - 프로퍼티, 함수추가
fun main( ){
    val coco = Bird("mybird",2,"short","blue")
    val lark = Lark("myLark",2,"long","brown")
    val parrot = Parrot("myparrot",2,"short","multiple","korean")

    println("Coco: ${coco.name},${coco.wing},${coco.beak}, ${coco.color}")
    println("Lark: ${lark.name},${lark.wing},${lark.beak}, ${lark.color}")
    println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")
    
    lark.singHitone( )
    parrot.speak( )
    lark.fly( )
}
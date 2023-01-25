class Bird { 
    //zz

    var name: String
    var wing: Int
    var beak: String
    var color: String

    constructor(name:String, wing: Int, beak: String, color: String ){
    this.name = name
    this.wing = wing
    this.beak = beak
    this.color = color
    }

    fun fly()= println("Fly Wing: $wing")
    fun sing(vol: Int) = println("Sing vol: $vol")

}
fun main( ){
    val coco =Bird("my bird",2,"short","blue")

    coco.color ="yellow"
    
    println("coco.color: ${coco.color}")
    coco.fly()
    coco.sing(3)
}
//부생성자

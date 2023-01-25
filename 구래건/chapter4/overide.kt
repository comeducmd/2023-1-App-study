open class Bird(var name: String, var wing: Int, var beak: String, var color: String){

    fun fly()= println("Fly Wing: $wing")
    open fun sing(vol: Int) = println("Sing vol: $vol")
}
class Parrot(name: String, wing: Int = 2, beak: String, color: String, var language: String = "natural") : Bird(name, wing, beak, color){
        fun speak( ) = println("Speak! $language")
        override fun sing(vol:Int){
            println("i'm a parrot! the volume level is $vol")
            speak( )
        } 
    }
fun main( ){
    val parrot = Parrot("myparrot",beak = "short",color = "multiple")
    parrot.language = "English"

    println("Parrot: ${parrot.name}, ${parrot.wing}, ${parrot.beak}, ${parrot.color}, ${parrot.language}")

    parrot.sing(5)


}

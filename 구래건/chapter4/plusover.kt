fun main() {
    val calc  = Calc( )
    println(calc.add(3,2))
    println(calc.add(3.2,1.3))
    println(calc.add(3,3,2))
    println(calc.add("hello","world"))

}
class Calc {
    fun add(x: Int, y: Int): Int =  x + y
    fun add(x: Double, y: Double): Double =  x + y
    fun add(x: Int, y: Int, z:Int): Int =  x + y + z
    fun add(x: String, y: String): String =  x + y //시용되는 인자에 따라 다르게 오버로딩

}

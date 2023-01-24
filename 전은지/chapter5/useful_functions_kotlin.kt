package com.example.myapplication

/*** 5-1 lambda function ***/
fun main() {
    // lambda function
    val sum = {no1: Int, no2: Int -> no1 + no2}
    val result = sum(10, 20);

    val result1 = {no1: Int, no2: Int -> no1 - no2} (10, 20);

    val some: (Int) -> Unit = {println(it)}
    some(10)

    val some1: (Int, Int) -> Int = {no1: Int, no2: Int -> no1 + no2}
}

// type alias
typealias MyInt = Int
typealias MyFunType = (Int, Int) -> Boolean // function type

val someFun: MyFunType = {no1: Int, no2: Int -> no1 == no2}  // can omit var type

// higher order function
fun hofFun(arg: (Int) -> Boolean): () -> String {
    val result = if (arg(10)) {
        "valid"
    } else {
        "invalid"
    }

    return {result}
}

val result = hofFun { num -> num>0 }

/*** 5-2 null safety ***/
/** null: declared, but not initialized, no memory allocation
 * use null -> NullPointException
 */

// null safety
var data: String? = null
val length = data?.length ?: 0
// ? operator : null -> not access to variable
// ?: elvis operator

// null exception operator !!
var len = data!!.length

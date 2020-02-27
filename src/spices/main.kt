package spices

fun main(args: Array<String>) {
    getSpices()
}

fun getSpices() {
    val mySpices = SimpleSpice()
    println("${mySpices.name} ${mySpices.heat}")
}
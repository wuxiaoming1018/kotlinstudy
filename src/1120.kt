fun main() {
    var list = listOf(1, 2, 3, 4, 5, 6)
    println(list.any { it > 8 })
    println(list.fold(0) { a, b -> a + b })
    println(list.fold(2) { a, b -> a * b })
    println(list.fold(1) { a, b -> a * b })
    println(list.fold(3) { a, b -> a * b })
}

fun add(x: Int, y: Int): Int {
    return x * y
}




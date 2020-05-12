
fun main() {
    val computer = Number(11, 20) { x, y -> x + y }
    computer.operation()
    computer.operator = { x, y -> x * y }
    computer.operation()
    computer.operator = { x, y -> y % x }
    computer.operation()

    val age = Age(26)
    println(age.isAudlt)
    age.age = 20
    println(age.isAudlt)
    age.addAge = 10
    println(age.isAudlt)
}


class Number(val num1: Int, val num2: Int, var operator: (Int, Int) -> Int) {
    fun operation() {
        println("Operator Result:${operator(num1, num2)}")
    }
}

class Age(age: Int) {
    var age: Int = age
        set(value) {
            field = value
            if (age >= 18) {
                isAudlt = true
            }
        }
    var isAudlt: Boolean = false
        private set
    var addAge: Int = 0
        set(value) {
            age += value
//            if (age >= 18) {
//                isAudlt = true
//            }
        }
}

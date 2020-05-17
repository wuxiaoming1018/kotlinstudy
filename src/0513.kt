fun main() {
    val computer = Computer(42, 24)
    computer.add()
    computer.subtract()
    computer.multiply()
    computer.divide()

    computer.pow(5)
}

class Computer(num1: Int, num12: Int) : CommonComputer, AdvanceComputer {
    var x = num1;
    var y = num12
    override fun add() {
        println(x + y)
    }

    override fun subtract() {
        println(x - y)
    }

    override fun multiply() {
        println(x * y)
    }

    override fun divide() {
        println(x / y)
    }

    override fun pow(up: Int) {
        var n1 = 1.0
        var n2 = 1.0
        for (index in 1..up) {
            n1 *= x
            n2 *= y
        }
        println("num1:$n1,num2:$n2")
    }

}

interface CommonComputer {
    fun add()
    fun subtract()
    fun multiply()
    fun divide()
}

interface AdvanceComputer {
    fun pow(up: Int)
}
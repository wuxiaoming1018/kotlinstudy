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

    val builder = Test.Builder().setName("张三")?.setAge(26)?.setSex("男")
    println(builder)

    let()
}

fun let() {
    //let操作符去掉null元素
    val listOf = listOf(1, 3, null, 8, "what", 9, 4, null,"9077")
    for (index in listOf) {
        if (index != null) {
            println("index-->$index")
        }
    }

    for (index in listOf) {
        index?.let {
            println("index2-->$index")
        }
    }
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

class Test {
    class Builder {
        var name: String? = "Tom"
        var age: Int? = 0
        var sex: String? = "man"

        fun setName(name: String): Builder? {
            this.name = name
            return this
        }

        fun setAge(age: Int): Builder? {
            this.age = age
            return this
        }

        fun setSex(sex: String): Builder? {
            this.sex = sex
            return this
        }

        override fun toString(): String {
            return "Builder(name:$name,age:$age,sex:$sex)"
        }
    }
}

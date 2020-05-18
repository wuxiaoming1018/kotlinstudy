fun main(args: Array<String>) {
    val person = PersonA(18, "woman", 165.0, 98.0)
    println(person)//默认调取.toString()
    //main函数中是不能调用protected修饰的函数，变量。protected修饰的只能在弗雷盒子类中调用

    println("------------------扩展----------------")
    val say = Say()
    say.sayBye()
    say.sayHi()
    say.sayGreat()
    980.sayHello()

    val map = mutableMapOf<String, Int?>()
    map.addNotNull("lok", 89)
    map.addNotNull(" ", 67)
    map.addNotNull("3io", null)
    map.addNotNull("opl", 562)
    println(map)

    val a: A = B()
    a.printlnHello()
    val b: B = B()
    b.printlnHello()

    val c = C("liming", 23)
    c.printlnInformation()
    c.printlnInformation(index = 10)

    println("----------属性扩展--------")
    val school = SchoolA()
    school.name = "nucbec"
    school.age = 89
    println(school.name)
    println(school.age)

    println("-------扩展函数范围问题------")
    println("一个类中内部对另一个类的扩展函数是可以在子类中覆盖的")
    val fruits = FruitsA(listOf("Apple", "Banana", "Watermelon"))
    val box = BoxA(90)
    val emptyBoxA = EmptyBoxA(28)
    box.haveFruits(fruits)
    println()
    emptyBoxA.haveFruits(fruits)
}


open class PersonA(age: Int, sex: String, height: Double, weight: Double) {
    protected var age = age
    protected var sex = sex
    protected var height = height
    protected var weight = weight

    protected fun printlnZero() {
        println(0)
    }

    override fun toString(): String {
        return "age:$age,sex:$sex,height:$height,weight:$weight"
    }
}

class StudentA(age: Int, sex: String, height: Double, weight: Double) : PersonA(age, sex, height, weight) {
    fun access() {
        println(age)
        printlnZero()
    }
}

//------------------类的扩展-------------

fun Say.sayGreat() {
    println("Great!")
}

fun Int.sayHello() {
    println("Hello,I am $this")
}

fun MutableMap<String, Int?>.addNotNull(key: String, value: Int?) {
    if (value != null) {
        this[key] = value
    }
}

class Say {
    fun sayHi() {
        println("Hi!")
    }

    fun sayBye() {
        println("Bye!")
    }
}

open class A {}
class B : A() {}

fun A.printlnHello() {
    println("hello,I am A!")
}

fun B.printlnHello() {
    println("hello,I am B!")
}

class C(name: String, age: Int) {
    var name: String = name
    var age: Int = age

    fun printlnInformation() {
        println("name:$name")
    }
}

fun C.printlnInformation(index: Int) {
    println("age:${this.age + index}")
}

//------------------属性扩展---------
class SchoolA {
    var name_: String = ""
    var age_: Int = 0
    fun hello() {
        println("hello")
    }
}

//扩展属性肯定要和类本身所携带的属性不同名称，不然毫无意义
var SchoolA.name: String
    get() = this.name_
    set(value) {
        this.name_ = value
    }

var SchoolA.age: Int
    get() = this.age_
    set(value) {
        this.age_ = value
    }

//--------扩展函数范围问题--------

class FruitsA(names: List<String>) {
    val names: List<String> = names
    fun printInformation() = names.forEach {
        print("$it ")
    }

    fun printNoFruits() = println("There is no fruit")
}

open class BoxA(size: Int) {
    val size: Int = size
    open fun FruitsA.printAll() {
        printInformation()
    }

    fun haveFruits(fruit: FruitsA) {
        println("I am a box,size is $size")
        println("I Have fruits:")
        fruit.printAll()
    }
}

class EmptyBoxA(size: Int) : BoxA(size) {
    override fun FruitsA.printAll() {
        printNoFruits()
    }
}


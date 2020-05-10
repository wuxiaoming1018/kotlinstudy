fun main() {
    val baby = Person("张三", 2);
    val parent1 = Person("大张", 46)
    val parent2 = Person("大三", 42)
    val child1 = Person("小明", 19, mutableListOf(parent1, parent2), mutableListOf(baby))
    val child2 = Person("小红", 20, mutableListOf(parent1, parent2), mutableListOf(baby))

    val smallChildren = Person("小屁孩", 1, mutableListOf(baby), mutableListOf(Person("00", 0)))

    println("-------个人信息-------")
    child1.showPersonalInformation()
    println("--------孩子信息---------")
    child1.showChildrenInformation()
    println("--------父母信息--------")
    child1.showParentsInformation()

    println("-----baby信息output：------")
    baby.showPersonalInformation()

    baby.showParentsInformation()
    println("-------bady children information")
    baby.showChildrenInformation()


    val numComp = NumberCompution(10, 20) { x, y -> x * y }
    numComp.operation()
    numComp.operator = { x, y -> x + y }
    numComp.operation()

    println("---------------")
    var student = Studen(10)
    println(student.isAdult)
    student.addAge = 16;
    println(student.isAdult)

    println("-------------")
    var index = Index(10)
    println(index.isAdult)
    index.addAge = 16
    println(index.isAdult)
    index.addAge = -9;
    println(index.isAdult)
}


class Person(name: String, age: Int) {

    val name: String = name;
    val age: Int = age;
    val children = mutableListOf<Person>()
    val parents = mutableListOf<Person>()

    constructor(name: String, age: Int, parents: MutableList<Person>, children: MutableList<Person>) : this(name, age) {
        parents.forEach { it.children.add(this) }
        children.forEach { it.parents.add(this) }
        this.parents.addAll(parents)
        this.children.addAll(children)
    }


    /**
     * 显示关于个人的名字与年龄信息
     */
    fun showPersonalInformation() = println("name:${name},age:${age}")


    /**
     * 显示关于孩子的名字与年龄信息
     */
    fun showChildrenInformation() = children.forEach {
        it.showPersonalInformation()
    }

    /**
     * 显示关于父母的名字与年龄信息
     */
    fun showParentsInformation() = parents.forEach {
        it.showPersonalInformation()
    }
}


class NumberCompution(val num1: Int, val num2: Int, var operator: (Int, Int) -> Int) {

    fun operation() {
        println("--------------")
        println("Operation result:${operator(num1, num2)}")
    }
}

class Studen(age: Int) {
    var age: Int = age
        set(value) {
            field = value
            if (age >= 18) {
                isAdult = true
            }
        }

    var isAdult: Boolean = false
        private set
    var addAge: Int = 0
        set(value) {
            age += value
        }
}


const val STR: String = "isAdult Changed"

class Index(age: Int) {
    var age: Int = age
        set(value) {
            field = value;
            if (age >= 18) {
                isAdult = true
                println(STR)
            }else
                isAdult = false
        }

    var isAdult: Boolean = false
        private set
    var addAge: Int = 0
        set(value) {
            age += value
        }

}
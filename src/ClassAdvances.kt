fun main() {

    val student = Student("小明", 20, 180, "beef", 300, 10, "浙江农林大学");
    student.name = "小明"
    student.age = 20
    student.height = 180
    student.likeFood = "beef"
    student.costByMonth = 300
    student.schoolName = "浙江农林大学"
    student.teacherNumber = 9


    val worker = Worker("罗子建2", 29, 178, "any", 12000, "中国深圳", 35000.0f)
    worker.name = "罗子建"
    worker.age = 29
    worker.height = 178
    worker.likeFood = "any"
    worker.salary = 3000.0f
    worker.nameOfWorkPlace = "中国深圳"
    worker.costByMonth = 12000

    student.printInformation()
    worker.printInformation()

    println("-------------")
    var school = School();
    school.name = "湖北第二师范学院"
    school.squre = 9000.0f
    school.printInformation()
    school.printInformation("我的母校")
    school.printInformation(count = 3)
}

open class Persons {
    constructor(name: String, age: Int, height: Int, likeFood: String, costByMonth: Int) {
        this.name = name
        this.age = age
        this.height = height
        this.likeFood = likeFood
        this.costByMonth = costByMonth
    }

    var name: String = ""
    var age: Int = 0
    var height: Int = 0
    var likeFood: String = ""
    var costByMonth: Int = 0
    open val sex: Int = 0
    protected val teacherName: String = "lisi"//this里面可见，子类里面也可见（可用）


    open fun printInformation() = println(
        "name:${name},age:${age},height:${height},likeFood:${likeFood}," +
                "costByMonth:${costByMonth}"
    )


}

class Student : Persons {
    constructor(
        name: String, age: Int, height: Int, likeFood: String, costByMonth: Int,
        teacherNumber: Int,
        schoolName: String
    ) : super(name, age, height, likeFood, costByMonth) {
        this.teacherNumber = teacherNumber
        this.schoolName = schoolName
    }


    override var sex: Int
        get() = super.sex
        set(value) {}

    var teacherNumber: Int = 0
    var schoolName: String = ""
    var teacher = teacherNumber
}

class Worker : Persons {
    constructor(
        name: String, age: Int, height: Int, likeFood: String, costByMonth: Int,
        nameOfWorkPlace: String,
        salary: Float
    ) : super(name, age, height, likeFood, costByMonth) {
        this.nameOfWorkPlace = nameOfWorkPlace
        this.salary = salary
    }

    var nameOfWorkPlace: String = ""
    var salary: Float = 0.0f
    override var sex: Int = 1

    override fun printInformation() {
        super.printInformation()
    }

    fun printSign(content: String) = println(content.toLowerCase())
}


class School {
    var name: String = "武汉大学"
    var squre: Float = 19000.0f

    fun printInformation() = println("name:${name}")
}

fun School.printInformation(content: String) = println("name:${this.name}" + content)

fun School.printInformation(count: Int) {
    for (i in 1..count) {
        println("name:${this.name}")
    }
}
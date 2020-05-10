import Factory as Factory

fun main(args: Array<String>) {
    var fruit = Fruits(listOf("Apple", "banana", "watermelon"))
    val box = Box(19)
    val emptyBox = EmptyBox(99)
    box.haveFruits(fruit)
    emptyBox.haveFruits(fruit)

    println("-----------------")

    val leaf_chun = Leaf("30", "green", "circle", 37)
    val leaf_xia = leaf_chun.copy(vein = 80)
    val leaf_qiu = leaf_xia.copy(color = "red")
    val leaf_dong = leaf_qiu.copy(size = "", color = "", shape = "", vein = 0)

    println("树叶的一生之春夏秋冬：")
    println("春季:$leaf_chun")
    println("夏季:$leaf_xia")
    println("秋季:$leaf_qiu")
    println("冬季:$leaf_dong")
    println(leaf_qiu.toString())

}

class Fruits(name: List<String>) {
    val name: List<String> = name

    fun printInformation() = name.forEach { println(it) }

    fun printNoFruits() = println("there is no fruit")

}

open class Box(size: Int) {
    val size: Int = size

    open fun Fruits.printAll() {
        printInformation()
    }


    fun haveFruits(fruits: Fruits) {
        println("I am a box ,size is ${size}")
        println("I have fruits:")
        fruits.printAll()
    }

}


class EmptyBox(size: Int) : Box(size) {
    override fun Fruits.printAll() {
        printNoFruits()
    }
}


data class Leaf(val size: String, val color: String, val shape: String, val vein: Int)


interface Factory<out T> {
    fun produce(): T

}

fun change(f: Factory<String>) {
    val factory_any: Factory<Any> = f
}


class MyFactory<T> : Factory<T> {

    override fun produce(): T {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
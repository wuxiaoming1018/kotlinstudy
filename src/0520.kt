//皮肤过敏，请了一天假

fun main(args: Array<String>) {
    val leaf = LeafA(14, "green", "circle", 67)
    val copy = leaf.copy(vein = 8)
    println(copy)
}

data class LeafA(var size: Int, var color: String, var shape: String, var vein: Int)
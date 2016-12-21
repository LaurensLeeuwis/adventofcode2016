package eu.leeuwis.adventofcode2016.december19

fun main(args: Array<String>) {

    val gifts = 3005290

    val presents: MutableList<Int> = (1..gifts).toMutableList()
    var iterations = 0

    while (presents.size > 1) {
        var i = 0
        while (i < presents.size) {
            val j = (i + presents.size / 2) % presents.size
            presents.removeAt(j)
            if (j > i) {
                i++
            }
            iterations++
        }
    }
    println("answer: ${presents[0]}")

}

package eu.leeuwis.adventofcode2016.december19

fun take(i: Int, number: Int): MutableList<Int> {
    val presents: MutableList<Int> = mutableListOf()
    repeat(i) {
        presents.add(number)
    }
    return presents
}

fun main(args: Array<String>) {

    val gifts = 3005290

    val presents: MutableList<Int> = take(gifts, 1)

    var windowSize = 1

    while(!presents.contains(gifts)) {

        for (i in 0..presents.size - 1) {
            if (presents[i] != 0) {
                var j = i + windowSize

                while (presents[j % presents.size] == 0) {
                    j++
                }
                val k = j % presents.size

                presents[i] = presents[i] + presents[k]
                presents[k] = 0
            }
        }

        windowSize *= 2
    }

    presents.forEachIndexed{ind, ele ->
        if (ele == gifts){
            println("all gifts found at position ${ind + 1}")
        }
    }

}

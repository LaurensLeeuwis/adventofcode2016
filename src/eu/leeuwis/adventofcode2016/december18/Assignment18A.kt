package eu.leeuwis.adventofcode2016.december18

fun main(args: Array<String>) {
    var line = givenInput
    var safeTiles = countSafes(line)
    println(line)

    repeat(40-1) {
        line = nextLine(line)
        safeTiles += countSafes(line)
        println(line)
    }

    println("safe tiles: ${safeTiles}")

}
package eu.leeuwis.adventofcode2016.december07

import java.io.File

fun main(args: Array<String>) {

    // input too large to declare as a val
    val result = File("src/eu/leeuwis/adventofcode2016/assignment7/input.txt").readLines().map {
                IP7Address(it)
            }.filter {
                it.hasTLS()
            }.count()

    println(result);

}
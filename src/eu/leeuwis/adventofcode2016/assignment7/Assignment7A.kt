package eu.leeuwis.adventofcode2016.assignment7

import java.io.File

fun main(args: Array<String>) {

    val result = File("src/eu/leeuwis/adventofcode2016/assignment7/assignment7.txt").readLines().map {
                IP7Address(it)
            }.filter {
                it.hasTLS()
            }.count()

    println(result);

}
package eu.leeuwis.adventofcode2016.assignment7

import java.io.File

fun main(args: Array<String>) {

    val result = File("src/eu/leeuwis/adventofcode2016/assignment7/input.txt").readLines().map {
                IP7Address(it)
            }.filter {
                it.hasSSL()
            }.count()

    println(result);

}
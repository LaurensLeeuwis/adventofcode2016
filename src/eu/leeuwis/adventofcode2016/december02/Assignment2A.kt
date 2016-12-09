package eu.leeuwis.adventofcode2016.december02

fun main(args: Array<String>) {
    var number = Number.FIVE

    givenInstructions.split("\n").forEach { line ->
        line.forEach { instruction ->
            when (instruction){
                'U' -> number = number.up()
                'D' -> number = number.down()
                'R' -> number = number.right()
                'L' -> number = number.left()
            }
        }
        println(number);
    }

}
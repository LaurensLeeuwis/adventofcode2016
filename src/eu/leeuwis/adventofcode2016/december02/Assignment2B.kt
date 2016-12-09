package eu.leeuwis.adventofcode2016.december02

fun main(args: Array<String>) {
    var keypad = Keypad.FIVE

    givenInstructions.split("\n").forEach { line ->
        line.forEach { instruction ->
            when (instruction){
                'U' -> keypad = keypad.up()
                'D' -> keypad = keypad.down()
                'R' -> keypad = keypad.right()
                'L' -> keypad = keypad.left()
            }
        }
        println(keypad);
    }

}
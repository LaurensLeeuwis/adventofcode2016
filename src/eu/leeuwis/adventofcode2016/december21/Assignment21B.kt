package eu.leeuwis.adventofcode2016.december21

val scrambled = "fbgdceah"

fun main(args: Array<String>) {
    var unscrambled = scrambled
    givenInput.split("\n").reversed().forEach {
        if (it.startsWith("rotate")) {
            if (it.contains("left")) {
                val steps = Integer.parseInt(it.substringAfter("left ").substringBefore(" step"))
                unscrambled = unscrambled.unRotateLeft(steps)
            } else if (it.contains("right")) {
                val steps = Integer.parseInt(it.substringAfter("right ").substringBefore(" step"))
                unscrambled = unscrambled.unRotateRight(steps)
            } else if (it.contains("position")) {
                val letter = it.substringAfter("letter ")[0]
                unscrambled = unscrambled.unRotateBasedOnLetter(letter)
            }
        } else if (it.startsWith("swap")) {
            if (it.contains("letter")) {
                val firstLetter = it.substringAfter("swap letter ").substringBefore(" with")[0]
                val secondLetter = it.substringAfter("with letter ")[0]
                unscrambled = unscrambled.unSwapLetters(firstLetter, secondLetter)
            } else if (it.contains("position")) {
                val firstPosition = Integer.parseInt(it.substringAfter("swap position ").substringBefore(" with"))
                val secondPosition = Integer.parseInt(it.substringAfter("with position "))
                unscrambled = unscrambled.unSwapPosition(firstPosition, secondPosition)
            }
        } else if (it.startsWith("move")) {
            val firstPosition = Integer.parseInt(it.substringAfter("move position ").substringBefore(" to"))
            val secondPosition = Integer.parseInt(it.substringAfter("to position "))
            unscrambled = unscrambled.unMovePosition(firstPosition, secondPosition)
        } else if (it.startsWith("reverse")) {
            val firstPosition = Integer.parseInt(it.substringAfter("reverse positions ").substringBefore(" through"))
            val secondPosition = Integer.parseInt(it.substringAfter("through "))
            unscrambled = unscrambled.unReversePositions(firstPosition, secondPosition)

        }
    }

    println("unscrambled password: $unscrambled")

}
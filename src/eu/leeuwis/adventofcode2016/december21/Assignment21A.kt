package eu.leeuwis.adventofcode2016.december21

val unscrambled = "abcdefgh"

fun main(args: Array<String>) {
    var scrambled = unscrambled
    givenInput.split("\n").forEach {
        if (it.startsWith("rotate")) {
            if (it.contains("left")) {
                val steps = Integer.parseInt(it.substringAfter("left ").substringBefore(" step"))
                scrambled = scrambled.rotateLeft(steps)
            } else if (it.contains("right")) {
                val steps = Integer.parseInt(it.substringAfter("right ").substringBefore(" step"))
                scrambled = scrambled.rotateRight(steps)
            } else if (it.contains("position")) {
                val letter = it.substringAfter("letter ")[0]
                scrambled = scrambled.rotateBasedOnLetter(letter)
            }
        } else if (it.startsWith("swap")) {
            if (it.contains("letter")) {
                val firstLetter = it.substringAfter("swap letter ").substringBefore(" with")[0]
                val secondLetter = it.substringAfter("with letter ")[0]
                scrambled = scrambled.swapLetters(firstLetter, secondLetter)
            } else if (it.contains("position")) {
                val firstPosition = Integer.parseInt(it.substringAfter("swap position ").substringBefore(" with"))
                val secondPosition = Integer.parseInt(it.substringAfter("with position "))
                scrambled = scrambled.swapPosition(firstPosition, secondPosition)
            }
        } else if (it.startsWith("move")) {
            val firstPosition = Integer.parseInt(it.substringAfter("move position ").substringBefore(" to"))
            val secondPosition = Integer.parseInt(it.substringAfter("to position "))
            scrambled = scrambled.movePosition(firstPosition, secondPosition)
        } else if (it.startsWith("reverse")) {
            val firstPosition = Integer.parseInt(it.substringAfter("reverse positions ").substringBefore(" through"))
            val secondPosition = Integer.parseInt(it.substringAfter("through "))
            scrambled = scrambled.reversePositions(firstPosition, secondPosition)

        }
    }

    println("scrambled password: $scrambled")

}
package eu.leeuwis.adventofcode2016.december09

fun main(args: Array<String>) {

    var cursorPosition = 0
    val positionTimes: MutableMap<Int, Int> = mutableMapOf()

    while (cursorPosition < givenInput.length) {
        val toProcess = givenInput.substring(cursorPosition)
        val before = toProcess.substringBefore("(")

        repeat(before.length) {
            positionTimes.getOrPut(cursorPosition, defaultValue = { 1 })
            cursorPosition++
        }

        if (toProcess == before) {
            break;
        }

        val instructionBlock = toProcess.substringAfter("(").substringBefore(")")
        val nrOfChars = Integer.parseInt(instructionBlock.substringBefore("x"))
        val nrOfTimes = Integer.parseInt(instructionBlock.substringAfter("x"))

        repeat(instructionBlock.length + 2) {
            positionTimes.remove(cursorPosition)
            cursorPosition++
        }

        for (i in cursorPosition..cursorPosition + nrOfChars - 1) {
            positionTimes.put(i,
                    positionTimes.getOrPut(i, defaultValue = { 1 }) * nrOfTimes)
        }

    }

    var result: Long = 0
    positionTimes.values.forEach {
        result += it
    }

    println(result)
}
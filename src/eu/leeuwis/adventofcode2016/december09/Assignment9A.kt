package eu.leeuwis.adventofcode2016.december09

fun main(args: Array<String>) {

    var cursorPosition = 0
    var result = ""

    while (cursorPosition < givenInput.length){
        val toProcess = givenInput.substring(cursorPosition)
        val before = toProcess.substringBefore("(")

        result+= before
        cursorPosition += before.length

        if (toProcess == before){
            break;
        }

        val instructionBlock = toProcess.substringAfter("(").substringBefore(")")
        val afterBlock = toProcess.substringAfter(")")
        val nrOfChars = Integer.parseInt(instructionBlock.substringBefore("x"))
        val nrOfTimes = Integer.parseInt(instructionBlock.substringAfter("x"))

        val chars = afterBlock.substring(0..nrOfChars-1).repeat(nrOfTimes)

        cursorPosition += instructionBlock.length + 2 + nrOfChars

        result += chars
    }

    println(result.length)

}
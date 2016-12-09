package eu.leeuwis.adventofcode2016.december06

fun main(args: Array<String>) {

    val positionCharacterCount : MutableMap<Int, MutableMap<Char, Int>> = mutableMapOf()

    givenInput.split("\n").forEach {
        it.toCharArray().forEachIndexed { index, character ->
            val characterCount = positionCharacterCount.getOrPut(index, defaultValue = {mutableMapOf()});
            val currentCount = characterCount.getOrPut(character, defaultValue = {0})
            characterCount.put(character, currentCount + 1)
        }
    }

    val errorCorrectedMessage = positionCharacterCount.map{
        val char = it.value.minBy{it.value}!!.key
        val pos = it.key
        pos to char
    }.sortedBy {
        it.first
    }.map{
        it.second
    }.joinToString(separator = "")

    println(errorCorrectedMessage)
}
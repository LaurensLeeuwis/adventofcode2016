package eu.leeuwis.adventofcode2016.assignment4

import kotlin.comparisons.compareBy

class Room(val encryptedName: String, val sectorId: Int, val checksum: String) {

    fun isReal(): Boolean {
        // fill a map with chars in the encrypted name and number of occurrences of the char
        val charAmount: MutableMap<Char, Int> = mutableMapOf()
        encryptedName.replace("-", "").forEach {
            val current = charAmount.getOrPut(it, defaultValue = { 0 })
            charAmount.put(it, current + 1)
        }

        // transpose the map to a map with number of occurrences and a list of characters with that number of occurrences
        val amountChars: MutableMap<Int, MutableList<Char>> = mutableMapOf()
        charAmount.forEach {
            val current = amountChars.getOrPut(it.value, defaultValue = { mutableListOf() })
            current.add(it.key)
        }

        // loop through that map, from highest to lowest number of occurrences. Check if the characters for this number
        // are all in the checksum, at the front of the current position
        var checksumPosition = 0
        amountChars.toSortedMap(compareBy { -it }).values.forEach {
            for (i in 1..it.size) {
                val checkSumChar = checksum[checksumPosition]
                if (!it.contains(checkSumChar)) {
                    return false
                }

                checksumPosition++
                if (checksumPosition >= checksum.length) {
                    return true
                }
            }
        }

        return false;
    }


    fun getRealName() : String {
        return encryptedName.split("-").filter { it.length > 0 }.map {
            it.map {
                val value = it.toInt();
                val posAlphabet = value - 97
                val newPosAlphabet = (sectorId + posAlphabet).mod(26)
                val newChar = (newPosAlphabet + 97).toChar()

                newChar
            }.joinToString(separator = "")
        }.joinToString(separator = " ")
    }

}
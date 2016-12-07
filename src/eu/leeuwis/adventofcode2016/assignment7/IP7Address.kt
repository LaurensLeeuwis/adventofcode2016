package eu.leeuwis.adventofcode2016.assignment7

import java.util.regex.Pattern

class IP7Address(val fullAddress: String) {

    private fun String.containsAbba(): Boolean {
        for (i in 0..(length - 4)) {
            val chars = substring(i, i + 4).toCharArray()
            if (chars[0] == chars[3] && chars[1] == chars[2] && chars[0] != chars[1]) {
                return true
            }
        }
        return false
    }

    fun hasTLS(): Boolean {
        val addressComponents = fullAddress.split(Pattern.compile("(\\[)|(\\])"))
        val componentsAbbas = addressComponents.map{ it.containsAbba() }
        val abbasInSupernet = componentsAbbas.filterIndexed { index, boolean -> index % 2 == 0 }.fold(false){ a,b -> a || b}
        val abbasInHypernet = componentsAbbas.filterIndexed { index, boolean -> index % 2 != 0 }.fold(false){ a,b -> a || b}
        return abbasInSupernet && !abbasInHypernet
    }

}
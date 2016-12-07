package eu.leeuwis.adventofcode2016.assignment7

import java.util.regex.Pattern

class IP7Address(fullAddress: String) {

    val addressComponents = fullAddress.split(Pattern.compile("(\\[)|(\\])"))

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
        val componentsAbbas = addressComponents.map { it.containsAbba() }
        val abbasInSupernet = componentsAbbas.filterIndexed { index, boolean -> index % 2 == 0 }.fold(false) { a, b -> a || b }
        val abbasInHypernet = componentsAbbas.filterIndexed { index, boolean -> index % 2 != 0 }.fold(false) { a, b -> a || b }
        return abbasInSupernet && !abbasInHypernet
    }

    private fun String.getAbas(): List<String> {
        val threeletters: MutableList<String> = mutableListOf()
        for (i in 0..(length - 3)) {
            val chars = substring(i, i + 3).toCharArray()
            if (chars[0] == chars[2] && chars[0] != chars[1]) {
                threeletters.add(chars.joinToString(separator = ""))
            }
        }
        return threeletters
    }

    fun hasSSL(): Boolean {
        val componentsAbas = addressComponents.map { it.getAbas() }
        val abasInSupernet = componentsAbas.filterIndexed { index, boolean -> index % 2 == 0 }.flatten()
        val abasInHypernet = componentsAbas.filterIndexed { index, boolean -> index % 2 != 0 }.flatten()

        abasInSupernet.forEach{
            val bab = "${it.substring(1)}${it.substring(1,2)}"
            if (abasInHypernet.contains(bab)) {
                return true
            }
        }
        return false
    }


}
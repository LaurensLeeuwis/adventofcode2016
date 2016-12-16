package eu.leeuwis.adventofcode2016.december14

import java.security.MessageDigest

val MD5_DIGEST = MessageDigest.getInstance("MD5")
val HEX_CHARS = "0123456789abcdef".toCharArray()

fun Byte.toHexString(): String {
    val i = this.toInt()
    val char2 = HEX_CHARS[i and 0x0f]
    val char1 = HEX_CHARS[i shr 4 and 0x0f]
    return "$char1$char2"
}


/*
For example, if the pre-arranged salt is abc:

The first index which produces a triple is 18, because the MD5 hash of abc18 contains ...cc38887a5.... However, index 18 does not count as a key for your one-time pad, because none of the next thousand hashes (index 19 through index 1018) contain 88888.
The next index which produces a triple is 39; the hash of abc39 contains eee. It is also the first key: one of the next thousand hashes (the one at index 816) contains eeeee.
None of the next six triples are keys, but the one after that, at index 92, is: it contains 999 and index 200 contains 99999.
Eventually, index 22728 meets all of the criteria to generate the 64th key.
 */


fun main(args: Array<String>) {

    val triples: MutableMap<Int, Char> = mutableMapOf()
    val validKeys: MutableList<Triple<Int, Char, Int>> = mutableListOf()
    var i = -1

    while (validKeys.size < 64) {
        i++;
        val input = "abc" + i
        val md5hash = MD5_DIGEST.digest(input.toByteArray()).map { it.toHexString() }

        if (isTriple(md5hash)) {
            val char = findTripleChar(md5hash)!!
            triples.put(i, char)
        }

        if (shouldFindFives(triples, i)) {
            val fives = findFiveChar(md5hash);

            if (fives.size > 0) {
                triples.entries.filter { i > it.key && it.key >= i - 1000 }
                        .filter { fives.contains(it.value) }
                        .forEach {
                            validKeys.add(Triple(it.key, it.value, i))
                        }
                validKeys.forEach {
                    triples.remove(it.first)
                }

            }
        }

    }

    println("keys: ${validKeys.sortedBy{it.first}.mapIndexed{ind, it ->"[i:${ind},validKey:${it.first},char:${it.second},fivesKey:${it.third}]"}.joinToString()}")

}

fun shouldFindFives(triples: Map<Int, Char>, iteration: Int): Boolean {
    return !triples.filter{iteration > it.key && it.key >= iteration - 1000}.isEmpty()
}

fun isTriple(md5hash: List<String>): Boolean {
    return findTripleChar(md5hash) != null
}

fun findTripleChar(md5hash: List<String>): Char? {
    md5hash.forEachIndexed() { i, twoChars ->
        if (twoChars[0] == twoChars[1] && (((i > 1) && md5hash[i - 1][1] == twoChars[0]) || ((i < md5hash.size - 2) && md5hash[i + 1][0] == twoChars[1]))) {
            println("${md5hash.joinToString(separator = "")} char: ${twoChars[0]}")
            return twoChars[0]
        }
    }
    return null
}

fun findFiveChar(md5hash: List<String>): List<Char> {
    val fives: MutableList<Char> = mutableListOf()
    md5hash.joinToString(separator = "").toCharArray().sliding(5).forEach {
        if (it.sliding(2).map { it[0] == it[1] }.reduce { a, b -> a && b }) {
            fives.add(it[0])
        }
    }
    return fives
}

fun CharArray.sliding(size: Int): List<CharArray> {
    return dropLast(size - 1).mapIndexed { index, boolean -> copyOfRange(index, index + size) }
}

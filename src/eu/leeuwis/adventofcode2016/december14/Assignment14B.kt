package eu.leeuwis.adventofcode2016.december14

import java.security.MessageDigest

val MD5_DIGEST = MessageDigest.getInstance("MD5")
val HEX_CHARS = "0123456789abcdef".toCharArray()

fun Byte.toHex(): List<Char> {
    val i = this.toInt()
    val char2 = HEX_CHARS[i and 0x0f]
    val char1 = HEX_CHARS[i shr 4 and 0x0f]
    return listOf(char1, char2)
}


/*
For example, if the pre-arranged salt is abc:

The first index which produces a triple is 18, because the MD5 hash of abc18 contains ...cc38887a5.... However, index 18 does not count as a key for your one-time pad, because none of the next thousand hashes (index 19 through index 1018) contain 88888.
The next index which produces a triple is 39; the hash of abc39 contains eee. It is also the first key: one of the next thousand hashes (the one at index 816) contains eeeee.
None of the next six triples are keys, but the one after that, at index 92, is: it contains 999 and index 200 contains 99999.
Eventually, index 22728 meets all of the criteria to generate the 64th key.
 */


fun main(args: Array<String>) {

    var foundValues = 0;
    var iteration = 0;

    while (foundValues < 64) {
        iteration++

        val input = givenInput + iteration
        val md5hash = MD5_DIGEST.digest(input.toByteArray()).flatMap { it.toHex() }.toCharArray()

        if (isTriple(md5hash)) {
            val char = findTripleChar(md5hash)!!

            for(i in iteration+1..iteration+1000){
                val input2 = givenInput + i
                val md5hash2 = MD5_DIGEST.digest(input2.toByteArray()).flatMap { it.toHex() }.toCharArray()

                if (containsFive(md5hash2, char)){
                    foundValues++

                    if (foundValues == 64){
                        println("found at: ${iteration}")
                    }
                }
            }
        }
    }
}

fun containsFive(md5hash: CharArray, char: Char): Boolean {
    md5hash.sliding(5).forEach{
        if (it.sliding(2).map { it[0] == it[1] }.reduce { a, b -> a && b }) {
            if (it[0] == char){
                return true
            }
        }
    }
    return false
}


fun isTriple(md5hash: CharArray): Boolean {
    return findTripleChar(md5hash) != null
}

fun findTripleChar(md5hash: CharArray): Char? {
    md5hash.sliding(3).forEach{if(it.sliding(2).map{it[0] == it[1]}.reduce{a,b -> a && b}){
        return it[0]
    }}

    return null
}

fun CharArray.sliding(size: Int): List<CharArray> {
    return dropLast(size - 1).mapIndexed { index, boolean -> copyOfRange(index, index + size) }
}

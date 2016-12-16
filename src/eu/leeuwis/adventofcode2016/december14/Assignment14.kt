package eu.leeuwis.adventofcode2016.december14

import java.security.MessageDigest

val givenInput = "ahsbgdzn";
val MD5_DIGEST = MessageDigest.getInstance("MD5")
val HEX_CHARS = "0123456789abcdef".toCharArray()

fun Byte.toHex(): List<Char> {
    val i = this.toInt()
    val char2 = HEX_CHARS[i and 0x0f]
    val char1 = HEX_CHARS[i shr 4 and 0x0f]
    return listOf(char1, char2)
}

fun calculateHash(input: String):CharArray {
    return MD5_DIGEST.digest(input.toByteArray()).flatMap { it.toHex() }.toCharArray()
}

fun containsFiveOf(md5hash: CharArray, char: Char): Boolean {
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
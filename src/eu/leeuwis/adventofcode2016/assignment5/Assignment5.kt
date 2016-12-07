package eu.leeuwis.adventofcode2016.assignment5

import java.security.MessageDigest

val HEX_CHARS = "0123456789abcdef".toCharArray()
val MD5_DIGEST = MessageDigest.getInstance("MD5")

fun isPassword(md5hash: ByteArray) : Boolean {
    for (i in 0..1){
        val octet = md5hash.get(i).toInt()
        val firstIndex = (octet and 0xF0).ushr(4)
        val secondIndex = octet and 0x0F
        if (firstIndex != 0 || secondIndex != 0){
            return false
        }
    }
    val octet = md5hash.get(2).toInt()
    return (octet and 0xF0).ushr(4) == 0
}

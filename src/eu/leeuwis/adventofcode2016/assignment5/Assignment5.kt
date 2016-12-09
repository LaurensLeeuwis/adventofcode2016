package eu.leeuwis.adventofcode2016.assignment5

import java.security.MessageDigest

val HEX_CHARS = "0123456789abcdef".toCharArray()
val MD5_DIGEST = MessageDigest.getInstance("MD5")

val roomId = "cxdnnyjw"

fun isPassword(md5hash: ByteArray) : Boolean {
    if (md5hash.get(1).toInt() != 0 || md5hash.get(0).toInt() != 0){
        return false
    }

    val octet = md5hash.get(2).toInt()
    return (octet and 0xF0).ushr(4) == 0
}

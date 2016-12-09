package eu.leeuwis.adventofcode2016.assignment5

fun main(args: Array<String>) {

    var password = ""
    var increment = 0;

    while(password.length != 8){
        val token = roomId + increment;
        val md5hash = MD5_DIGEST.digest(token.toByteArray())

        if (isPassword(md5hash)){
            password += getPasswordCharacter(md5hash)
        }

        increment++
    }

    println(password)
}

private fun getPasswordCharacter(md5hash: ByteArray) : Char {
    val octet = md5hash.get(2).toInt()
    return HEX_CHARS[octet and 0x0F]
}
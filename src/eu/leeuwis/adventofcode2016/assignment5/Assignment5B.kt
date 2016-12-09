package eu.leeuwis.adventofcode2016.assignment5

fun main(args: Array<String>) {

    val password = "________".toCharArray()
    var increment = 0;

    while(password.contains('_')){
        val token = roomId + increment;
        val md5hash = MD5_DIGEST.digest(token.toByteArray())

        if (isPassword(md5hash)){
            val position = getPasswordPosition(md5hash);

            if (0 <= position && position <= 7 && password[position] == '_'){
                password[position] = getPasswordCharacter(md5hash)
            }
        }

        increment++
    }

    println(password)
}

private fun getPasswordPosition(md5hash: ByteArray) : Int {
    val octet = md5hash.get(2).toInt()
    return octet and 0x0F
}

private fun getPasswordCharacter(md5hash: ByteArray) : Char {
    val octet = md5hash.get(3).toInt()
    return HEX_CHARS[(octet and 0xF0).ushr(4)]
}

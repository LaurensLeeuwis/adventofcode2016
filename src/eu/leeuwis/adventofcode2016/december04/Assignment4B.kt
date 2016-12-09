package eu.leeuwis.adventofcode2016.december04

fun main(args: Array<String>) {

    givenInstructions.split("\n").forEach { line ->
        val checksum = getChecksum(line)
        val sector = getSector(checksum, line)
        val encryptedName = getEncryptedName(checksum, line, sector)

        val room = Room(encryptedName, sector, checksum)

        if (room.isReal()){
            if(room.getRealName() == "northpole object storage"){
                println(room.sectorId)
                return
            }
        }
    }

}
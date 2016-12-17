package eu.leeuwis.adventofcode2016.december17

import java.security.MessageDigest

private val MD5_DIGEST = MessageDigest.getInstance("MD5")

class Room(val passcode: String, val path: String) {

    val isUpOpen: Boolean
    val isDownOpen: Boolean
    val isLeftOpen: Boolean
    val isRightOpen: Boolean
    val hasVault: Boolean

    init {
        val hash = MD5_DIGEST.digest((passcode + path).toByteArray())
        val currentLocation = calculateLocation(path)

        isUpOpen = isOpen(hash, 0) && currentLocation.x != 0
        isDownOpen = isOpen(hash, 1) && currentLocation.x != 3
        isLeftOpen = isOpen(hash, 2) && currentLocation.y != 0
        isRightOpen = isOpen(hash, 3) && currentLocation.y != 3
        hasVault = currentLocation == Coordinate(3,3)
    }

    fun getOpenRooms() : List<Room> {
        val openRooms : MutableList<Room> = mutableListOf()
        if (isDownOpen){
            openRooms.add(Room(passcode, path + "D"))
        }
        if (isUpOpen){
            openRooms.add(Room(passcode, path + "U"))
        }
        if (isRightOpen){
            openRooms.add(Room(passcode, path + "R"))
        }
        if (isLeftOpen){
            openRooms.add(Room(passcode, path + "L"))
        }
        return openRooms
    }

    private fun calculateLocation(path: String): Coordinate {
        var coordinate = Coordinate(0,0)

        path.forEach{
            if (it == 'U'){
                coordinate = coordinate.up()
            } else if (it == 'D'){
                coordinate = coordinate.down()
            } else if (it == 'R'){
                coordinate = coordinate.right()
            } else if (it == 'L'){
                coordinate = coordinate.left()
            }
        }
        return coordinate

    }

    private fun isOpen(hash: ByteArray, pos: Int): Boolean {
        val byte = if (pos < 2) hash[0] else hash[1]
        val i = byte.toInt()
        val hexNr = if (pos == 1 || pos == 3) i and 0x0f else i shr 4 and 0x0f
        return hexNr > 10
    }
}


private data class Coordinate(val x:Int, val y:Int){
    fun up(): Coordinate {
        return Coordinate(x - 1, y)
    }
    fun down(): Coordinate {
        return Coordinate(x + 1, y)
    }
    fun left(): Coordinate {
        return Coordinate(x, y - 1)
    }
    fun right(): Coordinate {
        return Coordinate(x, y + 1)
    }
}
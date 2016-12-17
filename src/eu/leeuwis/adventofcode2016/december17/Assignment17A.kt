package eu.leeuwis.adventofcode2016.december17

fun main(args: Array<String>) {

    var rooms = listOf(initialRoom)

    while (rooms.filter{it.hasVault}.size == 0) {
       rooms = nextRooms(rooms)
    }

    val vaultRoom = rooms.filter{it.hasVault}.first()

    println("path: ${vaultRoom.path}")
}


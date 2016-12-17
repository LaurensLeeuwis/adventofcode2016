package eu.leeuwis.adventofcode2016.december17

fun main(args: Array<String>) {

    val room = Room("lpvhkcbi", "")
    var rooms = listOf(room)

    while (rooms.filter{it.hasVault}.size == 0) {
       rooms = nextRooms(rooms)
    }

    val vaultRoom = rooms.filter{it.hasVault}.first()

    println("path: ${vaultRoom.path}")
}

fun nextRooms(rooms: List<Room>): List<Room> {
    val nextRooms : MutableList<Room> = mutableListOf()

    rooms.forEach {
        nextRooms.addAll(it.getOpenRooms())
    }

    return nextRooms
}


package eu.leeuwis.adventofcode2016.december17

val initialRoom = Room("lpvhkcbi", "")

fun nextRooms(rooms: List<Room>): List<Room> {
    val nextRooms : MutableList<Room> = mutableListOf()

    rooms.forEach {
        nextRooms.addAll(it.getOpenRooms())
    }

    return nextRooms
}
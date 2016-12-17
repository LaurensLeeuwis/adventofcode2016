package eu.leeuwis.adventofcode2016.december17

fun main(args: Array<String>) {

    var rooms = listOf(initialRoom)
    val vaultRooms: MutableList<Room> = mutableListOf()

    while (!rooms.isEmpty()) {
        vaultRooms.addAll(rooms.filter { it.hasVault })
        rooms = nextRooms(rooms)
    }

    println("longest path length: ${vaultRooms.map{it.path}.sortedByDescending{it.length}.first().length}")
}


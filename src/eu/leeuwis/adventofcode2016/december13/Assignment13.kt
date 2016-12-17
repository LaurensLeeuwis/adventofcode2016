package eu.leeuwis.adventofcode2016.december13

val givenInput = 1362

fun nextCoordinates(coordinates: List<Coordinate>, visited: MutableCollection<Coordinate>): List<Coordinate> {
    val nextCoordinates : MutableList<Coordinate> = mutableListOf()

    coordinates.forEach {
        if (!visited.contains(it)){
            nextCoordinates.addAll(it.getOpenSpaces())
        }
    }
    visited.addAll(coordinates)

    return nextCoordinates
}
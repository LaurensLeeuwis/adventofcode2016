package eu.leeuwis.adventofcode2016.december13

fun main(args: Array<String>){

    val start = Coordinate(1,1)
    var coordinates = listOf(start)
    val destination = Coordinate(31,39)
    var iteration = 0
    val visited : MutableList<Coordinate> = mutableListOf()

    while(!coordinates.contains(destination)){
        coordinates = nextCoordinates(coordinates, visited)
        iteration++
    }

    println("found ${iteration}")
}

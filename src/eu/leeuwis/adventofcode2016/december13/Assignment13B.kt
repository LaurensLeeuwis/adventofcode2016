package eu.leeuwis.adventofcode2016.december13

fun main(args: Array<String>){

    val start = Coordinate(1,1)
    var coordinates = listOf(start)
    val visited : MutableSet<Coordinate> = mutableSetOf()

    repeat(51){
        coordinates = nextCoordinates(coordinates, visited)
    }

    println("found ${visited.size}")
}

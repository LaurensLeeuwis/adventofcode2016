package eu.leeuwis.adventofcode2016.assignment1

data class Coordinate(val x: Int, val y: Int) {

    fun move(direction: Direction, amount: Int) : Coordinate {
        when (direction) {
            Direction.NORTH -> return Coordinate(x + amount, y)
            Direction.EAST -> return Coordinate(x, y + amount)
            Direction.SOUTH -> return Coordinate(x - amount, y)
            Direction.WEST -> return Coordinate(x, y - amount)
        }
    }

}
package eu.leeuwis.adventofcode2016.december01

fun main(args: Array<String>) {
    var coordinate = Coordinate(0,0)
    var direction = Direction.NORTH

    val instructions = givenInstructions.split(", ");

    instructions.forEach { instruction ->
        val turn = instruction.substring(0, 1)
        val amount = Integer.parseInt(instruction.substring(1))

        direction = if (turn == "R") direction.right() else direction.left()

        coordinate = coordinate.move(direction, amount);
    }

    println("final coordinate: " + coordinate)
    println("blocks away: " + (Math.abs(coordinate.x) + Math.abs(coordinate.y)))

}
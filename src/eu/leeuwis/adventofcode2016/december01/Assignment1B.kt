package eu.leeuwis.adventofcode2016.december01

fun main(args: Array<String>) {
    var coordinate = Coordinate(0,0)
    var direction = Direction.NORTH

    val instructions = givenInstructions.split(", ");

    val visitedCoordinates : MutableList<Coordinate> = mutableListOf()
    visitedCoordinates.add(coordinate);

    for (instruction in instructions) {
        val turn = instruction.substring(0, 1)
        val amount = Integer.parseInt(instruction.substring(1))

        direction = if (turn == "R") direction.right() else direction.left()

        repeat(amount){
            coordinate = coordinate.move(direction, 1);

            if (visitedCoordinates.contains(coordinate)){
                println("coordinate " + coordinate + " already visited!")
                println("blocks away: " + (Math.abs(coordinate.x) + Math.abs(coordinate.y)))
                return
            }

            visitedCoordinates.add(coordinate)
        }
    }
}
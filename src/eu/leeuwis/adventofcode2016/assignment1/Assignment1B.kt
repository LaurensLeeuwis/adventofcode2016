package eu.leeuwis.adventofcode2016.assignment1

import java.util.*

fun main(args: Array<String>) {
    var coordinate = Coordinate(0,0)
    var direction = Direction.NORTH

    val givenInstructions = "R5, L2, L1, R1, R3, R3, L3, R3, R4, L2, R4, L4, R4, R3, L2, L1, L1, R2, R4, R4, L4, R3, L2, R1, L4, R1, R3, L5, L4, L5, R3, L3, L1, L1, R4, R2, R2, L1, L4, R191, R5, L2, R46, R3, L1, R74, L2, R2, R187, R3, R4, R1, L4, L4, L2, R4, L5, R4, R3, L2, L1, R3, R3, R3, R1, R1, L4, R4, R1, R5, R2, R1, R3, L4, L2, L2, R1, L3, R1, R3, L5, L3, R5, R3, R4, L1, R3, R2, R1, R2, L4, L1, L1, R3, L3, R4, L2, L4, L5, L5, L4, R2, R5, L4, R4, L2, R3, L4, L3, L5, R5, L4, L2, R3, R5, R5, L1, L4, R3, L1, R2, L5, L1, R4, L1, R5, R1, L4, L4, L4, R4, R3, L5, R1, L3, R4, R3, L2, L1, R1, R2, R2, R2, L1, L1, L2, L5, L3, L1";
    val instructions = givenInstructions.split(", ");

    val visitedCoordinates = ArrayList<Coordinate>()
    visitedCoordinates.add(coordinate);

    for (instruction in instructions) {
        val turn = instruction.substring(0, 1)
        val amount = Integer.parseInt(instruction.substring(1))

        direction = if (turn == "R") direction.right() else direction.left()

        for (i in 1..amount){
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
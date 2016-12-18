package eu.leeuwis.adventofcode2016.december11

import eu.leeuwis.adventofcode2016.december11.Moveables.Elevator
import eu.leeuwis.adventofcode2016.december11.Moveables.*
import java.util.*

fun main(args: Array<String>) {

    val initialState = listOf(
            EnumSet.of(Elevator, Microchip_Promethium, Generator_Promethium, Generator_Elerium, Microchip_Elerium, Generator_Dilithium, Microchip_Dilithium),
            EnumSet.of(Generator_Cobalt, Generator_Curium, Generator_Ruthenium, Generator_Plutonium),
            EnumSet.of(Microchip_Cobalt, Microchip_Curium, Microchip_Ruthenium, Microchip_Plutonium),
            EnumSet.noneOf(Moveables::class.java))

    val desiredState = getDesiredState()

    val stepsTaken = stepsTaken(desiredState, initialState)

    println("It took ${stepsTaken} moves to reach the desired state")
}

private fun moveableCombinations(moveablesOnFloor: Set<Moveables>): Set<EnumSet<Moveables>> {
    val combinations: MutableSet<EnumSet<Moveables>> = mutableSetOf()
    val moveablesWithoutElevator = moveablesOnFloor.filter { it != Elevator }

    moveablesWithoutElevator.forEach {
        combinations.add(EnumSet.of(it))
    }

    moveablesWithoutElevator.dropLast(1).forEachIndexed { index, moveable ->
        for (i in index + 1..moveablesWithoutElevator.size - 1) {
            val combination = EnumSet.of(moveable, moveablesWithoutElevator[i])
            if (isValid(combination)) {
                combinations.add(combination)
            }
        }
    }

    return combinations
}

private fun canMoveUp(state: List<Set<Moveables>>, take: Set<Moveables>): Boolean {
    val thisFloor = thisFloor(state)
    if (thisFloor == 3) {
        return false
    }

    return canMove(state, take, thisFloor, 1)
}

private fun canMoveDown(state: List<Set<Moveables>>, take: Set<Moveables>): Boolean {
    val thisFloor = thisFloor(state)
    if (thisFloor == 0) {
        return false
    }

    return canMove(state, take, thisFloor, -1)
}

private fun canMove(state: List<Set<Moveables>>, take: Set<Moveables>, thisFloor: Int, direction: Int): Boolean {
    val nextFloorMoveables = state[thisFloor + direction] + take

    if (isValid(nextFloorMoveables)) {
        val thisFloorMovables = state[thisFloor] - take
        return isValid(thisFloorMovables)
    }
    return false
}

private fun thisFloor(state: List<Set<Moveables>>): Int = state.indexOfFirst { it.contains(Elevator) }

private fun isValid(moveables: Set<Moveables>): Boolean {
    val allMicrochips = moveables.filter { it.isMicrochip() }.toSet()
    var microchips = allMicrochips

    val allGenerators = moveables.filter { it.isGenerator() }.toSet()
    allGenerators.forEach {
        microchips -= it.complementingMicrochips
    }

    if (!microchips.isEmpty()) {
        return allGenerators.isEmpty()
    }

    return true
}


private fun moveElevatorUp(state: List<EnumSet<Moveables>>, take: EnumSet<Moveables>): List<EnumSet<Moveables>> {
    return moveElevator(state, take, 1)
}

private fun moveElevatorDown(state: List<EnumSet<Moveables>>, take: EnumSet<Moveables>): List<EnumSet<Moveables>> {
    return moveElevator(state, take, -1)
}

private fun moveElevator(state: List<EnumSet<Moveables>>, take: EnumSet<Moveables>, direction: Int): List<EnumSet<Moveables>> {
    val elevatorFloor = thisFloor(state)
    val result = copyStateMutable(state)

    val newElevatorFloorMoveables: MutableSet<Moveables> = mutableSetOf()
    newElevatorFloorMoveables.addAll(state[elevatorFloor])
    newElevatorFloorMoveables.removeAll(take + Elevator)
    result[elevatorFloor] = if (newElevatorFloorMoveables.isEmpty()) EnumSet.noneOf(Moveables::class.java) else EnumSet.copyOf(newElevatorFloorMoveables)

    val newDirectionFloorMoveables: MutableSet<Moveables> = mutableSetOf()
    newDirectionFloorMoveables.addAll(result[elevatorFloor + direction])
    newDirectionFloorMoveables.addAll(take + Elevator)
    result[elevatorFloor + direction] = if (newDirectionFloorMoveables.isEmpty()) EnumSet.noneOf(Moveables::class.java) else EnumSet.copyOf(newDirectionFloorMoveables)

    return result
}

private fun copyStateMutable(state: List<EnumSet<Moveables>>): MutableList<EnumSet<Moveables>> {
    val result: MutableList<EnumSet<Moveables>> = mutableListOf()
    result.addAll(state)
    return result
}

private fun stepsTaken(desiredState: List<EnumSet<Moveables>>, initialState: List<EnumSet<Moveables>>): Int {
    val evaluateStates = mutableSetOf(initialState)
    val evaluatedStates: MutableSet<List<EnumSet<Moveables>>> = mutableSetOf()
    var stepsTaken = 0

    while (!evaluateStates.contains(desiredState)) {
        stepsTaken++

        val currentEvaluateStates = evaluateStates.copy()
        evaluateStates.clear()

        currentEvaluateStates.forEachIndexed { iteration, state ->
            val thisFloor = thisFloor(state)
            val moveablesOnFloor = state[thisFloor]
            val combinations = moveableCombinations(moveablesOnFloor)

            combinations.forEach { combination ->
                if (canMoveUp(state, combination)) {
                    val nextState = moveElevatorUp(state, combination)
                    evaluateStates.add(nextState)
                }
                if (canMoveDown(state, combination)) {
                    val nextState = moveElevatorDown(state, combination)
                    evaluateStates.add(nextState)
                }
            }
        }

        evaluatedStates.addAll(currentEvaluateStates)
        evaluateStates.removeAll(evaluatedStates)

        println("$stepsTaken steps taken. Evaluated ${currentEvaluateStates.size} states this step (total: ${evaluatedStates.size}). Evaluate ${evaluateStates.size} states next iteration)")
    }
    return stepsTaken
}

private fun getDesiredState(): List<EnumSet<Moveables>> {
    return listOf(EnumSet.noneOf(Moveables::class.java),
            EnumSet.noneOf(Moveables::class.java),
            EnumSet.noneOf(Moveables::class.java),
            EnumSet.allOf(Moveables::class.java))
}

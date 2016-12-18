package eu.leeuwis.adventofcode2016.december11

private fun moveableCombinations(moveablesOnFloor: List<Moveable>): Set<Set<Moveable>> {
    val combinations: MutableSet<Set<Moveable>> = mutableSetOf()
    moveablesOnFloor.forEach {
        combinations.add(setOf(it))
    }

    moveablesOnFloor.dropLast(1).forEachIndexed { index, moveable ->
        for (i in index + 1..moveablesOnFloor.size - 1) {
            combinations.add(setOf(moveable, moveablesOnFloor[i]))
        }
    }

    return combinations.filter(::isValid).toSet()
}

fun canMoveUp(state: List<Set<Moveable>>, take: Set<Moveable>): Boolean {
    val thisFloor = thisFloor(state)
    if (thisFloor == 3) {
        return false
    }

    return canMove(state, take, thisFloor, 1)
}

fun canMoveDown(state: List<Set<Moveable>>, take: Set<Moveable>): Boolean {
    val thisFloor = thisFloor(state)
    if (thisFloor == 0) {
        return false
    }

    return canMove(state, take, thisFloor, -1)
}

private fun canMove(state: List<Set<Moveable>>, take: Set<Moveable>, thisFloor: Int, direction: Int): Boolean {
    val nextFloorMoveables = state[thisFloor + direction].mutableCopy()
    nextFloorMoveables.addAll(take)

    val thisFloorMovables = state[thisFloor].mutableCopy()
    thisFloorMovables.removeAll(take)

    return isValid(nextFloorMoveables) && isValid(thisFloorMovables)
}

private fun thisFloor(state: List<Set<Moveable>>): Int = state.indexOfFirst { it.contains(Elevator) }

fun isValid(moveables: Set<Moveable>): Boolean {
    val allMicrochips = moveables.filter { it is Microchip }.toSet()
    val microchips = allMicrochips.mutableCopy()

    val allGenerators = moveables.filter { it is Generator }.toSet()
    allGenerators.forEach {
        if (it is Generator) {
            microchips.remove(Microchip(it.element))
        }
    }

    if (!microchips.isEmpty()) {
        return allGenerators.isEmpty()
    }

    return true

}


fun moveElevatorUp(state: List<Set<Moveable>>, take: Set<Moveable>): List<Set<Moveable>> {
    return moveElevator(state, take, 1)
}

fun moveElevatorDown(state: List<Set<Moveable>>, take: Set<Moveable>): List<Set<Moveable>> {
    return moveElevator(state, take, -1)
}

private fun moveElevator(state: List<Set<Moveable>>, take: Set<Moveable>, direction: Int): List<Set<Moveable>> {
    val elevatorFloor = state.indexOfFirst { it.contains(Elevator) }
    val result = copyStateMutable(state)

    result[elevatorFloor].removeAll(take + Elevator)
    result[elevatorFloor + direction].addAll(take + Elevator)

    return result
}

private fun copyStateMutable(state: List<Set<Moveable>>): List<MutableSet<Moveable>> {
    val result: MutableList<MutableSet<Moveable>> = mutableListOf()
    state.forEach {
        val elements = it.mutableCopy()
        result.add(elements)
    }
    return result
}

fun <T> Set<T>.copy(): Set<T> {
    return this.mutableCopy()
}

fun <T> Set<T>.mutableCopy(): MutableSet<T> {
    val copy: MutableSet<T> = mutableSetOf()
    copy.addAll(this)
    return copy
}

fun stepsTaken(desiredState: List<Set<Moveable>>, initialState: List<Set<Moveable>>): Int {
    val evaluateStates = mutableSetOf(initialState)
    val evaluatedStates: MutableSet<List<Set<Moveable>>> = mutableSetOf()
    var stepsTaken = 0

    while (!evaluateStates.contains(desiredState)) {
        stepsTaken++

        val currentEvaluateStates = evaluateStates.copy()
        evaluateStates.clear()

        currentEvaluateStates.forEach { state ->
            state.forEach { floor ->
                if (floor.contains(Elevator)) {
                    val moveablesOnFloor = floor.filter { it !is Elevator }
                    val combinations = moveableCombinations(moveablesOnFloor)

                    combinations.forEach {
                        if (canMoveUp(state, it)) {
                            val nextState = moveElevatorUp(state, it)
                            if (!evaluatedStates.contains(nextState)) {
                                evaluateStates.add(nextState)
                            }
                        }
                        if (canMoveDown(state, it)) {
                            val nextState = moveElevatorDown(state, it)
                            if (!evaluatedStates.contains(nextState)) {
                                evaluateStates.add(nextState)
                            }
                        }
                    }

                }
            }
            evaluatedStates.add(state)
        }

        println("${stepsTaken} steps taken (${evaluatedStates.size} states evaluated, evaluate ${evaluateStates.size} states next iteration)")
    }
    return stepsTaken
}

fun getDesiredState(initialState: List<Set<Moveable>>): List<Set<Moveable>> {
    val allMoveables = initialState.flatten().toSet()
    return listOf(setOf(),setOf(),setOf(),allMoveables)
}

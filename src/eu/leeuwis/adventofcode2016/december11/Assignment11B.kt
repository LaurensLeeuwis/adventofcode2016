package eu.leeuwis.adventofcode2016.december11

fun main(args: Array<String>) {

    val initialState = listOf(
            setOf(Elevator, Microchip("promethium"), Generator("promethium"), Generator("elerium"), Microchip("elerium"), Generator("dilithium"), Microchip("dilithium")),
            setOf(Generator("cobalt"), Generator("curium"), Generator("ruthenium"), Generator("plutonium")),
            setOf(Microchip("cobalt"), Microchip("curium"), Microchip("ruthenium"), Microchip("plutonium")),
            setOf())

    val desiredState = getDesiredState(initialState)

    val stepsTaken = stepsTaken(desiredState, initialState)

    println("result found at iteration ${stepsTaken}")
}


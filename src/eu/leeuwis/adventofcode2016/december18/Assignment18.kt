package eu.leeuwis.adventofcode2016.december18

val givenInput = ".^^..^...^..^^.^^^.^^^.^^^^^^.^.^^^^.^^.^^^^^^.^...^......^...^^^..^^^.....^^^^^^^^^....^^...^^^^..^"

fun countSafes(line: String) = line.count { it == '.' }

fun nextLine(line: String): String {
    val input = ".${line}.".toCharArray()
    return input.dropLast(2).mapIndexed { ind, ele ->
        arrayOf(input[ind], input[ind + 1], input[ind + 2])
    }.map {
        if (it[0] == '^' && it[1] == '^' && it[2] == '.') {
            '^'
        } else if (it[0] == '.' && it[1] == '^' && it[2] == '^') {
            '^'
        } else if (it[0] == '.' && it[1] == '.' && it[2] == '^') {
            '^'
        } else if (it[0] == '^' && it[1] == '.' && it[2] == '.') {
            '^'
        } else {
            '.'
        }
    }.joinToString(separator = "")
}
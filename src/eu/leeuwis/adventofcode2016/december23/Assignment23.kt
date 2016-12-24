package eu.leeuwis.adventofcode2016.december23

import eu.leeuwis.adventofcode2016.december12.Cpy
import eu.leeuwis.adventofcode2016.december12.Dec
import eu.leeuwis.adventofcode2016.december12.Inc
import eu.leeuwis.adventofcode2016.december12.Jnz

val givenInput = """cpy a b
dec b
cpy a d
cpy 0 a
cpy b c
plus a c
cpy 0 c
nothing
dec d
jnz d -5
dec b
cpy b c
cpy c d
plus c d
cpy 0 d
nothing
tgl c
cpy -16 c
jnz 1 c
cpy 78 c
jnz 70 d
plus a d
cpy 0 d
nothing
inc c
jnz c -5"""

fun getInstructions(): MutableList<Any> {
    val instructions: MutableList<Any> = mutableListOf()

    givenInput.split("\n").forEach {
        if (it.startsWith("cpy")) {
            val input = it.substringAfter("cpy ")
            val x = input.substringBefore(" ")
            val y = input.substringAfter(" ")
            instructions.add(Cpy(x, y))
        } else if (it.startsWith("inc")) {
            val x = it.substringAfter("inc ")
            instructions.add(Inc(x))
        } else if (it.startsWith("dec")) {
            val x = it.substringAfter("dec ")
            instructions.add(Dec(x))
        } else if (it.startsWith("jnz")) {
            val input = it.substringAfter("jnz ")
            val x = input.substringBefore(" ")
            val y = input.substringAfter(" ")
            instructions.add(Jnz(x, y))
        } else if (it.startsWith("tgl")) {
            val x = it.substringAfter("tgl ")
            instructions.add(Tgl(x))
        } else if (it.startsWith("nothing")){
            instructions.add(Nothing())
        } else if (it.startsWith("plus")){
            val input = it.substringAfter("plus ")
            val x = input.substringBefore(" ")
            val y = input.substringAfter(" ")
            instructions.add(Plus(x, y))
        }
    }
    return instructions
}
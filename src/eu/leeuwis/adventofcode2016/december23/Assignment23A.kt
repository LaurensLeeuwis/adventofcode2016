package eu.leeuwis.adventofcode2016.december23

import eu.leeuwis.adventofcode2016.december12.Instruction
import eu.leeuwis.adventofcode2016.december12.Jnz
import eu.leeuwis.adventofcode2016.december12.Register

fun main(args: Array<String>){
    var instructions: List<Any> = getInstructions()

    var i = 0
    var registers = mapOf("a" to Register(7), "b" to Register(0), "c" to Register(0), "d" to Register(0))

    while (i < instructions.size){
        val instruction = instructions[i]

        if (instruction is Instruction){
            registers = instruction.apply(registers)
            i++
        } else if (instruction is Jnz){
            i += instruction.apply(registers)
        } else if (instruction is Tgl){
            instructions = instruction.apply(registers, instructions, i)
            i++
        }
    }

    println("value in register a: ${registers.get("a")}")
}
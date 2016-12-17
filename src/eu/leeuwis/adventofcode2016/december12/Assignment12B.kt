package eu.leeuwis.adventofcode2016.december12

fun main(args: Array<String>){
    val instructions: MutableList<Any> = getInstructions()

    var i = 0
    var registers = mapOf("a" to Register(0), "b" to Register(0), "c" to Register(1), "d" to Register(0))

    while (i < instructions.size){
        val instruction = instructions[i]

        if (instruction is Instruction){
            registers = instruction.apply(registers)
            i++
        } else if (instruction is Jnz){
            i += instruction.apply(registers)
        }
    }

    println("value in register a: ${registers.get("a")}")
}
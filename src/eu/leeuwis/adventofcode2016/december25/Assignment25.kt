package eu.leeuwis.adventofcode2016.december25

import eu.leeuwis.adventofcode2016.december12.*

fun main(args: Array<String>) {
    val instructions: MutableList<Any> = getInstructions()

    val signal: MutableList<Int> = mutableListOf()

    var a = 0

    while(!isWhatIWant(signal)){
        var registers = mapOf("a" to Register(a), "b" to Register(0), "c" to Register(0), "d" to Register(0))

        signal.clear()
        var i = 0

        while (i < instructions.size && signal.size < 20) {
            val instruction = instructions[i]

            if (instruction is Instruction) {
                if (instruction is Out) {
                    val value = instruction.getValue(registers)
                    signal.add(value.value)
                } else {
                    registers = instruction.apply(registers)
                }

                i++
            } else if (instruction is Jnz) {
                i += instruction.apply(registers)
            }
        }

        System.out.println("for $a in a, signal is: ${signal.joinToString()}")
        a++
    }


}

fun isWhatIWant(signal: List<Int>): Boolean {
    return signal.size == 20 && signal[0] != signal[1]
            && signal[0] == signal[2] && signal[2] == signal[4]
            && signal[4] == signal[6] && signal[6] == signal[8]
            && signal[8] == signal[10] && signal[10] == signal[12]
            && signal[12] == signal[14] && signal[14] == signal[16]
            && signal[16] == signal[18]
            && signal[1] == signal[3] && signal[3] == signal[5]
            && signal[5] == signal[7] && signal[7] == signal[9]
            && signal[9] == signal[11] && signal[11] == signal[13]
            && signal[13] == signal[15] && signal[15] == signal[17]
            && signal[17] == signal[19]
}

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
        } else if (it.startsWith("out")) {
            val x = it.substringAfter("out ")
            instructions.add(Out(x))
        }
    }
    return instructions
}


val givenInput = """cpy a d
cpy 7 c
cpy 365 b
inc d
dec b
jnz b -2
dec c
jnz c -5
cpy d a
jnz 0 0
cpy a b
cpy 0 a
cpy 2 c
jnz b 2
jnz 1 6
dec b
dec c
jnz c -4
inc a
jnz 1 -7
cpy 2 b
jnz c 2
jnz 1 4
dec b
dec c
jnz 1 -4
jnz 0 0
out b
jnz a -19
jnz 1 -21"""
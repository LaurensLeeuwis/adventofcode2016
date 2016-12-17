package eu.leeuwis.adventofcode2016.december12

val givenInput = """cpy 1 a
cpy 1 b
cpy 26 d
jnz c 2
jnz 1 5
cpy 7 c
inc d
dec c
jnz c -2
cpy a c
inc a
dec b
jnz b -2
cpy c b
dec d
jnz d -6
cpy 16 c
cpy 17 d
inc a
dec d
jnz d -2
dec c
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
        }
    }
    return instructions
}
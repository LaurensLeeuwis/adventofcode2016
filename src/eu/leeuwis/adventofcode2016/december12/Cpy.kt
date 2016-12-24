package eu.leeuwis.adventofcode2016.december12

class Cpy(val first: String, val second: String) : Instruction {

    override fun apply(registers: Map<String, Register>): Map<String, Register> {
        val result: MutableMap<String, Register> = mutableMapOf()
        result.putAll(registers)

        val from = registers.getOrElse(first, { Register(Integer.parseInt(first)) })
        if (registers.contains(second)){
            result.put(second, from)
        }

        return result
    }
}
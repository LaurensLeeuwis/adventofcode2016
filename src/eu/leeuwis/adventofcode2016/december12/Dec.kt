package eu.leeuwis.adventofcode2016.december12

class Dec(val register: String) : Instruction {
    override fun apply(registers: Map<String, Register>): Map<String, Register> {
        val result: MutableMap<String, Register> = mutableMapOf()
        result.putAll(registers)

        result.put(register, Register(registers.getOrElse(register, { Register(0) }).value - 1))
        return result
    }
}
package eu.leeuwis.adventofcode2016.december23

import eu.leeuwis.adventofcode2016.december12.*

class Plus(val register: String, val plus: String) : Instruction {

    override fun apply(registers: Map<String, Register>): Map<String, Register> {
        val result: MutableMap<String, Register> = mutableMapOf()
        result.putAll(registers)

        result.put(register, Register(registers.getOrElse(register, { Register(0) }).value + registers.getOrElse(plus, { Register(Integer.parseInt(plus)) }).value))
        return result
    }
}
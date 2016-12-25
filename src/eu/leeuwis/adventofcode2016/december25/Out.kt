package eu.leeuwis.adventofcode2016.december25

import eu.leeuwis.adventofcode2016.december12.Instruction
import eu.leeuwis.adventofcode2016.december12.Register

class Out(val register: String) : Instruction {
    override fun apply(registers: Map<String, Register>): Map<String, Register> {
        val value = getValue(registers).value
        println("out: $value")

        return registers
    }

    fun getValue(registers: Map<String, Register>): Register {
        return registers.getOrElse(register, { Register(Integer.parseInt(register)) })
    }

}
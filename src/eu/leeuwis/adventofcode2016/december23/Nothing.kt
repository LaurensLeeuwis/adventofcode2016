package eu.leeuwis.adventofcode2016.december23

import eu.leeuwis.adventofcode2016.december12.*

class Nothing() : Instruction {

    override fun apply(registers: Map<String, Register>): Map<String, Register> {
      return registers
    }
}
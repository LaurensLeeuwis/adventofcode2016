package eu.leeuwis.adventofcode2016.december12

interface Instruction {

    fun apply(registers: Map<String, Register>): Map<String, Register>

}
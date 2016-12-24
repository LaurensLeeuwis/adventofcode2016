package eu.leeuwis.adventofcode2016.december23

import eu.leeuwis.adventofcode2016.december12.*

class Tgl(val register: String) {

    fun apply(registers: Map<String, Register>, instructions: List<Any>, position: Int): List<Any> {
        val results = instructions.toMutableList()

        val registerValue = registers.get(register)!!.value
        val changePosition = position+registerValue

        if (changePosition < results.size-1){
            val changeInstruction = results[changePosition]

            if (changeInstruction is Tgl || changeInstruction is Dec){
                val register = if(changeInstruction is Tgl) changeInstruction.register else if (changeInstruction is Dec) changeInstruction.register else "0"

                results[changePosition] = Inc(register)
            } else if (changeInstruction is Inc){
                results[changePosition] = Dec(changeInstruction.register)
            } else if (changeInstruction is Jnz){
                results[changePosition] = Cpy(changeInstruction.x, changeInstruction.y)
            } else if (changeInstruction is Cpy){
                results[changePosition] = Jnz(changeInstruction.first, changeInstruction.second)
            }

        }
        return results
    }
}
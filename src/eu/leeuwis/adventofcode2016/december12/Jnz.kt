package eu.leeuwis.adventofcode2016.december12

class Jnz(val x: String, val y: String) {

    fun apply(registers: Map<String, Register>): Int {
        val xValue = registers.getOrElse(x, {Register(Integer.parseInt(x))}).value

        if (xValue == 0){
            return 1
        } else {
            return Integer.parseInt(y)
        }

    }


}
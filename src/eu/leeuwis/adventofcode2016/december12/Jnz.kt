package eu.leeuwis.adventofcode2016.december12

class Jnz(val x: String, val y: String) {

    fun apply(registers: Map<String, Register>): Int {
        val xValue = registers.getOrElse(x, {Register(Integer.parseInt(x))}).value
        val yValue = registers.getOrElse(y, {Register(Integer.parseInt(y))}).value

        if (xValue == 0){
            return 1
        } else {
            return yValue
        }

    }


}
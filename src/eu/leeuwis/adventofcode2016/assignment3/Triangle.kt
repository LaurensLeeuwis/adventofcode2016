package eu.leeuwis.adventofcode2016.assignment3

data class Triangle(val sideA: Int, val sideB: Int, val sideC: Int) {

    fun isValid() : Boolean {
        return sideA + sideB > sideC && sideA + sideC > sideB && sideB + sideC > sideA
    }

}
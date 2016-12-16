package eu.leeuwis.adventofcode2016.december15

data class Disc(val positions: Int, val initialPosition: Int) {

    fun isOpen(time : Int): Boolean{
        val currentPosition = (initialPosition + time) % positions
        return currentPosition == 0
    }

}
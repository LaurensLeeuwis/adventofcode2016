package eu.leeuwis.adventofcode2016.december13

data class Coordinate(val x: Int, val y: Int) {

    val isOpenSpace : Boolean by lazy { calculateOpenSpace()}

    fun calculateOpenSpace() : Boolean {
        val number = x*x + 3*x + 2*x*y + y + y*y
        val asBinary = Integer.toBinaryString(number + givenInput)

        return asBinary.count { it == '1' } % 2 == 0
    }

    fun getOpenSpaces() : List<Coordinate> {
        val result : MutableList<Coordinate> = mutableListOf()
        val a = Coordinate(x+1, y)
        val b = Coordinate(x-1, y)
        val c = Coordinate(x, y+1)
        val d = Coordinate(x, y-1)
        if (a.isOpenSpace) result.add(a)
        if (b.isOpenSpace) result.add(b)
        if (c.isOpenSpace) result.add(c)
        if (d.isOpenSpace) result.add(d)
        return result
    }
}
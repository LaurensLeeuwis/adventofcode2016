package eu.leeuwis.adventofcode2016.december08

class Screen(val wideSize: Int, val tallSize: Int) {

    private var window: MutableMap<Coordinate, Boolean> = mutableMapOf()

    init {
        for (widePos in 1..wideSize){
            for (tallPos in 1..tallSize){
                window.put(Coordinate(widePos, tallPos), false)
            }
        }
    }

    fun visualize() {
        for (tallPos in 1..tallSize){
            for (widePos in 1..wideSize){
                if (window.getOrElse(Coordinate(widePos, tallPos), defaultValue = {false})){
                    print("#")
                } else {
                    print(".")
                }
            }
            println()
        }
    }

    fun litPixels() : Int {
        var result = 0;

        for (pixel in window){
            if (pixel.value){
                result++
            }
        }

        return result
    }

    fun rect(wide: Int, tall: Int){
        for (widePos in 1..wide){
            for (tallPos in 1..tall){
                window.put(Coordinate(widePos, tallPos), true)
            }
        }
    }

    fun rotateRow(row: Int, by: Int){
        val rowNr = row + 1
        val newWindow: MutableMap<Coordinate, Boolean> = mutableMapOf()
        newWindow.putAll(window)

        for (widePos in 1..wideSize){
            val coordinate = Coordinate(widePos, rowNr)
            newWindow.put(coordinate.shiftRow(by, wideSize), window.getOrElse(coordinate, defaultValue = {false}))
        }
        window = newWindow
    }

    fun rotateColumn(column: Int, by: Int){
        val columnNr = column + 1
        val newWindow: MutableMap<Coordinate, Boolean> = mutableMapOf()
        newWindow.putAll(window)

        for (tallPos in 1..tallSize){
            val coordinate = Coordinate(columnNr, tallPos)
            newWindow.put(coordinate.shiftCol(by, tallSize), window.getOrElse(coordinate, defaultValue = {false}))
        }
        window = newWindow
    }

    private data class Coordinate(val widePos: Int, val tallPos: Int) {

        fun shiftCol(by: Int, tallSize: Int) : Coordinate {
            val zeroBasedCol = tallPos - 1
            val newTallPos = (zeroBasedCol + by) % tallSize
            val oneBasedCol = newTallPos + 1
            return Coordinate(widePos, oneBasedCol)
        }

        fun shiftRow(by: Int, wideSize: Int) : Coordinate {
            val zeroBasedRow = widePos - 1
            val newWidePos = (zeroBasedRow + by) % wideSize
            val oneBasedRow = newWidePos + 1
            return Coordinate(oneBasedRow, tallPos)
        }
    }

}
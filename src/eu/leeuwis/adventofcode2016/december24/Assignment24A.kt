package eu.leeuwis.adventofcode2016.december24

fun main(args: Array<String>) {

    val maze: MutableMap<Coordinate, Type> = mutableMapOf()
    val numbers: MutableMap<Coordinate, Int> = mutableMapOf()

    givenInput.split("\n").forEachIndexed { row, rowElements ->
        rowElements.forEachIndexed { col, colElement ->
            val coordinate = Coordinate(row, col)
            if (colElement == '#') {
                maze.put(coordinate, Type.WALL)
            } else if (colElement == '.') {
                maze.put(coordinate, Type.OPEN)
            } else {
                maze.put(coordinate, Type.NUMBER)
                val number = colElement.toString().toInt()
                numbers.put(coordinate, number)
            }
        }
    }

    val distance: MutableMap<Path, Steps> = mutableMapOf()

    val numberCoordinates = numbers.keys.toList()
    val paths: MutableList<Path> = mutableListOf()

    numberCoordinates.forEachIndexed { idx, coordinateFrom ->
        numberCoordinates.takeLast(numberCoordinates.size - idx - 1).forEach { coordinateTo ->
            paths.add(Path(coordinateFrom, coordinateTo))
        }
    }

    paths.forEach { path ->
        distance.put(path, calculateDistance(path, maze))
    }

    paths.forEach {
        distance.put(Path(it.to, it.from), distance.get(it)!!)
    }

    val possiblePaths: Set<List<Path>> = getPossiblePaths(numbers)

    var shortestPath = Int.MAX_VALUE

    possiblePaths.forEach{
        val thisPathLength = it.map{distance.get(it)!!}.sumBy{it.amount}
        if (thisPathLength < shortestPath){
            println("shortest is now ($thisPathLength steps): ${it.joinToString()}")
            shortestPath = thisPathLength
        }
    }

}

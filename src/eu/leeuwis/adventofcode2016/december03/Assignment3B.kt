package eu.leeuwis.adventofcode2016.december03

fun main(args: Array<String>) {
    var correctTriangles = 0;

    // transform input into list of list of integers
    val instructionNumbers : MutableList<MutableList<Int>> = mutableListOf()
    givenInstructions.split("\n").forEach { line ->
        val numbers = line.split(" ").filter{ it.isNotEmpty() }
        val numberList : MutableList<Int> = mutableListOf()

        for (i in 0..2){
            numberList.add(Integer.parseInt(numbers[i]))
        }
        instructionNumbers.add(numberList);
    }

    // construct and validate triangles
    for (i in 0..instructionNumbers.size-1 step 3) {
        for (j in 0..2){
            val triangle = Triangle(instructionNumbers.get(i).get(j),
                    instructionNumbers.get(i+1).get(j),
                    instructionNumbers.get(i+2).get(j));

            if (triangle.isValid()){
                correctTriangles++
            }
        }
    }

    println("correct triangles: " + correctTriangles);
}
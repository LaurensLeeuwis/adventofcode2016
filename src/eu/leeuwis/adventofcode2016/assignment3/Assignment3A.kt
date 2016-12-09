package eu.leeuwis.adventofcode2016.assignment3

fun main(args: Array<String>) {
    var correctTriangles = 0;

    givenInstructions.split("\n").forEach { line ->
        val numbers = line.split(" ").filter{ it.isNotEmpty()}
        val triangle = Triangle(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]))
        if (triangle.isValid()){
            correctTriangles++
        }
    }

    println("correct triangles: " + correctTriangles);
}
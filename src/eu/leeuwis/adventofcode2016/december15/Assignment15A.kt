package eu.leeuwis.adventofcode2016.december15

fun main(args: Array<String>){

    var time = 0;
    while (!allOpen(discs, time)){
        time++
    }

    println(time)
}

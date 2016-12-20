package eu.leeuwis.adventofcode2016.december20

fun main(args: Array<String>){

    var min : Long = 0

    blocked.forEach{
        if (it.first <= min && (it.second + 1) > min){
            min = it.second + 1
        }
    }

    println("first non-blocked IP: $min")
}
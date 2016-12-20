package eu.leeuwis.adventofcode2016.december20

fun main(args: Array<String>){
    val blocked = givenInput.split("\n").map{range ->
        val begin = range.substringBefore("-").toLong()
        val end = range.substringAfter("-").toLong()
        Pair(begin, end)
    }.sortedBy{it.first}

    var min : Long = 0

    blocked.forEach{
        if (it.first <= min && (it.second + 1) > min){
            min = it.second + 1
        }
    }

    println("first non-blocked IP: $min")
}
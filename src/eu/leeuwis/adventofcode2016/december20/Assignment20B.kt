package eu.leeuwis.adventofcode2016.december20

fun main(args: Array<String>){
    var free : Long = 0
    var count : Long = 0

    blocked.forEach{
        if (it.first <= free && (it.second + 1) > free){
            free = it.second + 1
        } else if (it.first > free){
            count += ((it.first-1) - free) +1
            free = it.second +1
        }
    }

    println("number of non-blocked IPs: $count")
}
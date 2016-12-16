package eu.leeuwis.adventofcode2016.december15

fun main(args: Array<String>){

    val moreDiscs = discs + Disc(11, 0)

    var time = 0;
    while (!allOpen(moreDiscs, time)){
        time++
    }

    println(time)
}

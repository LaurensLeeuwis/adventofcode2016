package eu.leeuwis.adventofcode2016.december15

val discs = arrayListOf(Disc(17,1), Disc(7,0), Disc(19,2), Disc(5,0), Disc(3,0), Disc(13,5))

fun allOpen(discs: List<Disc>, time: Int): Boolean {
    return discs.mapIndexed{delta, disc -> disc.isOpen(time + delta+1)}.reduce{a, b -> a && b}
}

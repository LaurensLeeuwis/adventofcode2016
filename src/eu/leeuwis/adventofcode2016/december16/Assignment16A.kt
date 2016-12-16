package eu.leeuwis.adventofcode2016.december16

fun main(args: Array<String>) {
    val input = "00111101111101000"
    val desiredLength = 272

    val diskFill = dragonCurve(from01String(input), desiredLength)
    val checkSum = checksum(diskFill)

    println(to01String(checkSum))
}

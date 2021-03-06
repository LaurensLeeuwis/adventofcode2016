package eu.leeuwis.adventofcode2016.december16

fun dragonCurve(input: BooleanArray, desiredLength: Int): BooleanArray {
    var result = input
    while(result.size < desiredLength){
        result = dragonCurve(result)
    }

    return result.sliceArray(0..desiredLength-1)
}


fun BooleanArray.negate() : BooleanArray {
    return map { !it }.toBooleanArray()
}

fun from01String(input: String): BooleanArray{
    return input.map{it == '1'}.toBooleanArray()
}

fun to01String(input: BooleanArray): String {
    return input.map{if (it){"1"} else {"0"}}.joinToString(separator = "")
}

fun dragonCurve(input: BooleanArray): BooleanArray{
    val a = input
    val b = input.reversedArray().negate()
    return a + false + b
}

fun BooleanArray.cut(cutsize: Int) : List<BooleanArray> {
    val result : MutableList<BooleanArray> = mutableListOf()
    for (i in 0..size-1 step cutsize){
        result.add(sliceArray(i..i+cutsize-1))
    }
    return result
}

fun singleChecksum(input: BooleanArray): BooleanArray {
    return input.cut(2).map{it.reduce { a,b -> a == b}}.toBooleanArray()
}

fun checksum(input: BooleanArray): BooleanArray{
    var result = singleChecksum(input)

    while (result.size %2 == 0){
        result = singleChecksum(result)
    }

    return result
}
package eu.leeuwis.adventofcode2016.december08

fun main(args: Array<String>) {

    val screen = Screen(50, 6)

    givenInput.split("\n").forEach {
        if (it.startsWith("rect")){
            val size = it.substringAfter("rect ")
            val a = Integer.parseInt(size.substringBefore("x"))
            val b = Integer.parseInt(size.substringAfter("x"))

            screen.rect(a,b)
        } else {
            val by = Integer.parseInt(it.substringAfter("by "))

            if (it.contains("row")){
                val pos = Integer.parseInt(it.substringAfter("y=").substringBefore(" by"))
                screen.rotateRow(pos, by)
            } else {
                val pos = Integer.parseInt(it.substringAfter("x=").substringBefore(" by"))
                screen.rotateColumn(pos, by)
            }

        }
    }

    println(screen.litPixels())

}
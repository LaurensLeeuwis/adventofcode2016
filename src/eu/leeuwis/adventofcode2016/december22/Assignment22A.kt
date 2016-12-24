package eu.leeuwis.adventofcode2016.december22

fun main(args: Array<String>){

    val REGEX = """/dev/grid/node-x(\d+)-y(\d+)\s*(\d+)T\s*(\d+)T\s*(\d+)T\s*(\d+)%""".toRegex()

    val input : MutableMap<Pair<Int,Int>, Triple<Int,Int,Int>> = mutableMapOf()
    val viablePairs : MutableSet<Pair<Pair<Int,Int>, Pair<Int,Int>>> = mutableSetOf()

    givenInput.split("\n").forEach{
        val groups = REGEX.matchEntire(it)?.groups
        val x = groups?.get(1)?.value?.toInt()
        val y = groups?.get(2)?.value?.toInt()
        val size = groups?.get(3)?.value?.toInt()
        val used = groups?.get(4)?.value?.toInt()
        val available =  groups?.get(5)?.value?.toInt()
        val use = groups?.get(6)?.value?.toInt()

        if (x != null && y != null && size != null && used != null && available != null)
        input.put(Pair(x,y),Triple(size,used,available))

        input.forEach{nodeInfoA ->
            val nodeA = nodeInfoA.key
            val infoA = nodeInfoA.value

            if (infoA.second != 0){
                input.forEach{
                    nodeInfoB ->
                    val nodeB = nodeInfoB.key
                    val infoB = nodeInfoB.value

                    if (nodeA != nodeB){
                        if (infoA.second <= infoB.third){
                            viablePairs.add(Pair(nodeA,nodeB))
                        }
                    }
                }
            }
        }
    }

    println("number of viable pairs: ${viablePairs.size}")

}
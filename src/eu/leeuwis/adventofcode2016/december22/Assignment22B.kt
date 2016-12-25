package eu.leeuwis.adventofcode2016.december22

fun main(args: Array<String>) {

    val REGEX = """/dev/grid/node-x(\d+)-y(\d+)\s*(\d+)T\s*(\d+)T\s*(\d+)T\s*(\d+)%""".toRegex()

    val input: MutableMap<Node, NodeDisk> = mutableMapOf()

    givenInput.split("\n").forEach {
        val groups = REGEX.matchEntire(it)?.groups
        val x = groups?.get(1)?.value?.toInt()
        val y = groups?.get(2)?.value?.toInt()
        val size = groups?.get(3)?.value?.toInt()
        val used = groups?.get(4)?.value?.toInt()
        val available = groups?.get(5)?.value?.toInt()

        if (x != null && y != null && size != null && used != null && available != null)
            input.put(Node(x, y), NodeDisk(size, used, available))
    }

    val goalNode = input.keys.filter { it.y == 0 }.sortedByDescending { it.x }.first()

    val viablePairs: MutableSet<Pair<Node, Node>> = mutableSetOf()

    input.forEach { nodeInfoA ->
        val nodeA = nodeInfoA.key
        val infoA = nodeInfoA.value

        if (infoA.used != 0) {
            input.forEach {
                nodeInfoB ->
                val nodeB = nodeInfoB.key
                val infoB = nodeInfoB.value

                if (nodeA != nodeB) {
                    if (infoA.used <= infoB.available) {
                        viablePairs.add(Pair(nodeA, nodeB))
                    }
                }
            }
        }
    }


    printMap(input, goalNode, viablePairs.toList())

    println(goalNode)


}

fun printMap(input: Map<Node, NodeDisk>, goalNode: Node, viablePairs: List<Pair<Node, Node>>) {
    val maxX = input.keys.sortedByDescending { it.x }.first().x
    val maxY = input.keys.sortedByDescending { it.y }.first().y

    for (y in 0..maxY) {
        for (x in 0..maxX) {
            val node = Node(x, y)
            val nodeDisk = input.get(node)
            val thisChar = if (node == goalNode) {
                "G"
            } else if (nodeDisk == null) {
                "?"
            } else if (nodeDisk.used == 0) {
                "_"
            } else if (nodeDisk.used > 100) {
                "#"
            } else if (viablePairs.map{listOf(it.first, it.second)}.flatten().contains(node)){
                "V"
            }else {
                "."
            }

            if (x == 0 && y == 0) {
                print("(${thisChar})")
            } else {
                print(" ${thisChar} ")
            }
        }
        println()
    }


}

data class Node(val x: Int, val y: Int)
data class NodeDisk(val size: Int, val used: Int, val available: Int)
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
    val goalNodeDisk = input.get(goalNode)

    moveNode(input, Node(17,22), Node(16,22))
    moveNode(input, Node(16,22), Node(15,22))
    moveNode(input, Node(15,22), Node(14,22))
    moveNode(input, Node(14,22), Node(13,22))
    moveNode(input, Node(13,22), Node(12,22))
    moveNode(input, Node(12,22), Node(11,22))
    moveNode(input, Node(11,22), Node(10,22))
    moveNode(input, Node(10,22), Node(9,22))
    moveNode(input, Node(9,22), Node(8,22))
    moveNode(input, Node(8,22), Node(7,22))
    moveNode(input, Node(7,22), Node(6,22))
    moveNode(input, Node(6,22), Node(5,22))
    moveNode(input, Node(5,22), Node(4,22))
    moveNode(input, Node(4,22), Node(3,22))
    moveNode(input, Node(3,22), Node(2,22))
    moveNode(input, Node(2,22), Node(1,22))
    moveNode(input, Node(1,22), Node(0,22))
    moveNode(input, Node(0,22), Node(0,21))
    moveNode(input, Node(0,21), Node(0,20))
    moveNode(input, Node(0,20), Node(0,19))
    moveNode(input, Node(0,19), Node(1,19))
    moveNode(input, Node(1,19), Node(2,19))
    moveNode(input, Node(2,19), Node(3,19))
    moveNode(input, Node(3,19), Node(4,19))
    moveNode(input, Node(4,19), Node(5,19))
    moveNode(input, Node(5,19), Node(6,19))
    moveNode(input, Node(6,19), Node(7,19))
    moveNode(input, Node(7,19), Node(8,19))
    moveNode(input, Node(8,19), Node(9,19))
    moveNode(input, Node(9,19), Node(10,19))
    moveNode(input, Node(10,19), Node(11,19))
    moveNode(input, Node(11,19), Node(12,19))
    moveNode(input, Node(12,19), Node(13,19))
    moveNode(input, Node(13,19), Node(14,19))
    moveNode(input, Node(14,19), Node(15,19))
    moveNode(input, Node(15,19), Node(16,19))
    moveNode(input, Node(16,19), Node(17,19))
    moveNode(input, Node(17,19), Node(18,19))
    moveNode(input, Node(18,19), Node(19,19))
    moveNode(input, Node(19,19), Node(20,19))
    moveNode(input, Node(20,19), Node(21,19))
    moveNode(input, Node(21,19), Node(22,19))
    moveNode(input, Node(22,19), Node(23,19))
    moveNode(input, Node(23,19), Node(24,19))
    moveNode(input, Node(24,19), Node(25,19))
    moveNode(input, Node(25,19), Node(26,19))
    moveNode(input, Node(26,19), Node(27,19))
    moveNode(input, Node(27,19), Node(28,19))
    moveNode(input, Node(28,19), Node(29,19))
    moveNode(input, Node(29,19), Node(30,19))
    moveNode(input, Node(30,19), Node(31,19))
    moveNode(input, Node(31,19), Node(32,19))
    moveNode(input, Node(32,19), Node(33,19))
    moveNode(input, Node(33,19), Node(34,19))
    moveNode(input, Node(34,19), Node(34,18))
    moveNode(input, Node(34,18), Node(34,17))
    moveNode(input, Node(34,17), Node(34,16))
    moveNode(input, Node(34,16), Node(34,15))
    moveNode(input, Node(34,15), Node(34,14))
    moveNode(input, Node(34,14), Node(34,13))
    moveNode(input, Node(34,13), Node(34,12))
    moveNode(input, Node(34,12), Node(34,11))
    moveNode(input, Node(34,11), Node(34,10))
    moveNode(input, Node(34,10), Node(34,9))
    moveNode(input, Node(34,9), Node(34,8))
    moveNode(input, Node(34,8), Node(34,7))
    moveNode(input, Node(34,7), Node(34,6))
    moveNode(input, Node(34,6), Node(34,5))
    moveNode(input, Node(34,5), Node(34,4))
    moveNode(input, Node(34,4), Node(34,3))
    moveNode(input, Node(34,3), Node(34,2))
    moveNode(input, Node(34,2), Node(34,1))
    moveNode(input, Node(34,1), Node(34,0))
    moveNode(input, Node(34,0), Node(35,0))

    moveNode(input, Node(35,0), Node(35,1))
    moveNode(input, Node(35,1), Node(34,1))
    moveNode(input, Node(34,1), Node(33,1))
    moveNode(input, Node(33,1), Node(33,0))
    moveNode(input, Node(33,0), Node(34,0))

    for (i in (2..34).reversed()){
        moveNode(input, Node(i,0), Node(i,1))
        moveNode(input, Node(i,1), Node(i-1,1))
        moveNode(input, Node(i-1,1), Node(i-2,1))
        moveNode(input, Node(i-2,1), Node(i-2,0))
        moveNode(input, Node(i-2,0), Node(i-1,0))
    }




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


    printMap(input, goalNodeDisk!!, viablePairs.toList())

    println(goalNode)

    println(steps)

}

var steps = 0

fun moveNode(input: MutableMap<Node, NodeDisk>, from: Node, to: Node) {
    val oldTo = input.get(to)
    input.put(to, input.get(from)!!)
    input.put(from, oldTo!!)
    steps++
}

fun printMap(input: Map<Node, NodeDisk>, goalNodeDisk: NodeDisk, viablePairs: List<Pair<Node, Node>>) {
    val maxX = input.keys.sortedByDescending { it.x }.first().x
    val maxY = input.keys.sortedByDescending { it.y }.first().y

    print("    ")
    for (x in 0..maxX){
        print("${if (x < 10) "0" else ""}$x ")
    }
    println()

    for (y in 0..maxY) {

        print("${if (y < 10) "0" else ""}$y  ")

        for (x in 0..maxX) {
            val node = Node(x, y)
            val nodeDisk = input.get(node)
            val thisChar = if (nodeDisk == goalNodeDisk) {
                "G"
            } else if (nodeDisk == null) {
                "?"
            } else if (nodeDisk.used == 0) {
                "_"
            } else if (nodeDisk.used > 100) {
                "#"
            } else if (viablePairs.contains(Pair(node, Node(x+1, y)))
            || viablePairs.contains(Pair(node, Node(x-1, y)))
            || viablePairs.contains(Pair(node, Node(x, y+1)))
            || viablePairs.contains(Pair(node, Node(x, y-1)))){
                "*"
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
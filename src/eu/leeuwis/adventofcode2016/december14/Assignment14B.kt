package eu.leeuwis.adventofcode2016.december14


fun main(args: Array<String>) {

    val indexHash: MutableMap<Int, CharArray> = mutableMapOf()
    val threes : MutableList<Int> = mutableListOf()
    val fives: MutableList<Int> = mutableListOf()

    var foundValues = 0;
    var iteration = 0;

    while (foundValues < 64) {

        val max = if (indexHash.isEmpty()){0}else{indexHash.keys.max()!!}

        for (i in max..iteration + 1000){
            val hash = calculateHash(inputForIteration(i), 2016)

            indexHash.put(i, hash)
            if (isTriple(hash)){
                threes.add(i)

                if (isFives(hash)){
                    fives.add(i)
                }
            }
        }

        if (threes.contains(iteration)){

            val threesChar = findTripleChar(indexHash.get(iteration)!!)!!

            val found = fives.filter{it > iteration}.firstOrNull{ containsFiveOf(indexHash.get(it)!!, threesChar)}
            if (found != null){
                foundValues++
                println("found ${foundValues}")
            }
        }

        iteration++
    }

    println("result: ${iteration-1}")
}

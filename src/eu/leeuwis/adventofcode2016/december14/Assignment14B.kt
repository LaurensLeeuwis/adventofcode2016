package eu.leeuwis.adventofcode2016.december14


fun main(args: Array<String>) {

    var foundValues = 0;
    var iteration = 0;

    while (foundValues < 64) {
        iteration++

        val input = givenInput + iteration
        val md5hash = calculateHash(input)

        if (isTriple(md5hash)) {
            val char = findTripleChar(md5hash)!!

            for(i in iteration+1..iteration+1000){
                val input2 = givenInput + i
                val md5hash2 = calculateHash(input)

                if (containsFiveOf(md5hash2, char)){
                    foundValues++

                    if (foundValues == 64){
                        println("found at: ${iteration}")
                    }
                }
            }
        }
    }
}



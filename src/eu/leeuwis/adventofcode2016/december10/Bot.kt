package eu.leeuwis.adventofcode2016.december10

class Bot(val number: Int) {

    var chip1 : Value? = null
    var chip2 : Value? = null

    fun addChip(chip: Value){
        if (chip1 == null){
            chip1 = chip
        } else if (chip2 == null){
            chip2 = chip
        } else {
            throw IllegalStateException()
        }
    }

    fun getLowerValue() : Int {
        if (chip1 == null || chip2 == null){
            throw IllegalStateException()
        }
        return Math.min(chip1!!.getValue(), chip2!!.getValue())
    }

    fun getHigherValue() : Int {
        if (chip1 == null || chip2 == null){
            throw IllegalStateException()
        }
        return Math.max(chip1!!.getValue(), chip2!!.getValue())
    }

}
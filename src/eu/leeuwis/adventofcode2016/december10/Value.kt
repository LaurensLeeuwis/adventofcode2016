package eu.leeuwis.adventofcode2016.december10

class Value {

    var lowValueFromBot : Bot? = null
    var highValueFromBot : Bot? = null
    var value : Int? = null

    fun getValue() : Int {
        if (value != null){
            return value!!
        } else if (lowValueFromBot != null){
            value = lowValueFromBot!!.getLowerValue()
            lowValueFromBot = null
            return value!!
        } else if (highValueFromBot != null){
            value = highValueFromBot!!.getHigherValue()
            highValueFromBot = null
            return value!!
        }
        throw IllegalStateException()
    }

}
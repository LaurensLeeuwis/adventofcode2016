package eu.leeuwis.adventofcode2016.december11

fun <T> Set<T>.copy(): Set<T> {
    return this.mutableCopy()
}

fun <T> Set<T>.mutableCopy(): MutableSet<T> {
    val copy: MutableSet<T> = mutableSetOf()
    copy.addAll(this)
    return copy
}
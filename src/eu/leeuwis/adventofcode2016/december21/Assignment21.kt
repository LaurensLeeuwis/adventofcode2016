package eu.leeuwis.adventofcode2016.december21

fun String.rotateLeft(steps: Int) : String {
    val shift = steps % this.length
    val toEnd = this.substring(0..shift-1)
    val rest = this.substring(shift..this.length-1)
    return rest + toEnd
}

fun String.rotateRight(steps: Int) : String {
    val shift = steps % this.length
    val toBegin = this.substring(this.length-shift..this.length-1)
    val rest = this.substring(0..this.length-shift-1)
    return toBegin + rest
}

fun String.reversePositions(from: Int, to: Int): String {
    val before = this.substring(0..from-1)
    val after = this.substring(to+1..this.length -1)
    val reversed = this.substring(from..to).reversed()
    return before + reversed + after
}


fun String.swapPosition(from: Int, to: Int): String{
    val before = (0..(this.length-1)).toMutableList()
    before[to] = from
    before[from] = to
    return before.map{this[it]}.joinToString(separator = "")
}

fun String.swapLetters(from: Char, to: Char): String {
    return this.map { if (it == from) to else if (it == to) from else it }.joinToString(separator = "")
}

fun String.movePosition(from: Int, to: Int): String {
    val before = (0..(this.length-1)).toMutableList()
    before.remove(from)
    val after = before.subList(0, to) + from + before.subList(to, before.size)
    return after.map{this[it]}.joinToString(separator = "")
}

fun String.rotateBasedOnLetter(letter: Char): String {
    var index = this.indexOf(letter)
    if (index >= 4){
        index++
    }
    return rotateRight(1 + index)
}

val givenInput = """rotate left 2 steps
rotate right 0 steps
rotate based on position of letter a
rotate based on position of letter f
swap letter g with letter b
rotate left 4 steps
swap letter e with letter f
reverse positions 1 through 6
swap letter b with letter d
swap letter b with letter c
move position 7 to position 5
rotate based on position of letter h
swap position 6 with position 5
reverse positions 2 through 7
move position 5 to position 0
rotate based on position of letter e
rotate based on position of letter c
rotate right 4 steps
reverse positions 3 through 7
rotate left 4 steps
rotate based on position of letter f
rotate left 3 steps
swap letter d with letter a
swap position 0 with position 1
rotate based on position of letter a
move position 3 to position 6
swap letter e with letter g
move position 6 to position 2
reverse positions 1 through 2
rotate right 1 step
reverse positions 0 through 6
swap letter e with letter h
swap letter f with letter a
rotate based on position of letter a
swap position 7 with position 4
reverse positions 2 through 5
swap position 1 with position 2
rotate right 0 steps
reverse positions 5 through 7
rotate based on position of letter a
swap letter f with letter h
swap letter a with letter f
rotate right 4 steps
move position 7 to position 5
rotate based on position of letter a
reverse positions 0 through 6
swap letter g with letter c
reverse positions 5 through 6
reverse positions 3 through 5
reverse positions 4 through 6
swap position 3 with position 4
move position 4 to position 2
reverse positions 3 through 4
rotate left 0 steps
reverse positions 3 through 6
swap position 6 with position 7
reverse positions 2 through 5
swap position 2 with position 0
reverse positions 0 through 3
reverse positions 3 through 5
rotate based on position of letter d
move position 1 to position 2
rotate based on position of letter c
swap letter e with letter a
move position 4 to position 1
reverse positions 5 through 7
rotate left 1 step
rotate based on position of letter h
reverse positions 1 through 7
rotate based on position of letter f
move position 1 to position 5
reverse positions 1 through 4
rotate based on position of letter a
swap letter b with letter c
rotate based on position of letter g
swap letter a with letter g
swap position 1 with position 0
rotate right 2 steps
rotate based on position of letter f
swap position 5 with position 4
move position 1 to position 0
swap letter f with letter b
swap letter f with letter h
move position 1 to position 7
swap letter c with letter b
reverse positions 5 through 7
rotate left 6 steps
swap letter d with letter b
rotate left 3 steps
swap position 1 with position 4
rotate based on position of letter a
rotate based on position of letter a
swap letter b with letter c
swap letter e with letter f
reverse positions 4 through 7
rotate right 0 steps
reverse positions 2 through 3
rotate based on position of letter a
reverse positions 1 through 4
rotate right 1 step"""
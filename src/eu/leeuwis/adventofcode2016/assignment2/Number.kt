package eu.leeuwis.adventofcode2016.assignment2

enum class Number {
    ONE {
        override fun right(): Number {
            return TWO
        }
        override fun down(): Number {
            return FOUR
        }
    },
    TWO {
        override fun left(): Number {
            return ONE
        }
        override fun right(): Number {
            return THREE
        }
        override fun down(): Number {
            return FIVE
        }
    },
    THREE {
        override fun left(): Number {
            return TWO
        }
        override fun down(): Number {
            return SIX
        }
    },
    FOUR {
        override fun up(): Number {
            return ONE
        }
        override fun right(): Number {
            return FIVE
        }
        override fun down(): Number {
            return SEVEN
        }
    },
    FIVE {
        override fun up(): Number {
            return TWO
        }
        override fun left(): Number {
            return FOUR
        }
        override fun right(): Number {
            return SIX
        }
        override fun down(): Number {
            return EIGHT
        }
    },
    SIX {
        override fun up(): Number {
            return THREE
        }
        override fun left(): Number {
            return FIVE
        }
        override fun down(): Number {
            return NINE
        }
    },
    SEVEN {
        override fun up(): Number {
            return FOUR
        }
        override fun right(): Number {
            return EIGHT
        }
    },
    EIGHT {
        override fun up(): Number {
            return FIVE
        }
        override fun left(): Number {
            return SEVEN
        }
        override fun right(): Number {
            return NINE
        }
    },
    NINE {
        override fun up(): Number {
            return SIX
        }
        override fun left(): Number {
            return EIGHT
        }
    };

    open fun up() : Number {
        return this
    }
    open fun left() : Number {
        return this
    }
    open fun right() : Number {
        return this
    }
    open fun down() : Number {
        return this
    }
}
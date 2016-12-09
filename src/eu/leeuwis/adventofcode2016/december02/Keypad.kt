package eu.leeuwis.adventofcode2016.december02

enum class Keypad {
    ONE {
        override fun down(): Keypad {
            return THREE
        }
    },
    TWO {
        override fun down(): Keypad {
            return SIX
        }

        override fun right(): Keypad {
            return THREE
        }
    },
    THREE {
        override fun up(): Keypad {
            return ONE
        }

        override fun right(): Keypad {
            return FOUR
        }

        override fun left(): Keypad {
            return TWO
        }

        override fun down(): Keypad {
            return SEVEN
        }
    },
    FOUR {
        override fun up(): Keypad {
            return EIGHT
        }

        override fun left(): Keypad {
            return THREE
        }
    },
    FIVE {
        override fun right(): Keypad {
            return SIX
        }
    },
    SIX {
        override fun down(): Keypad {
            return A
        }

        override fun up(): Keypad {
            return TWO
        }

        override fun right(): Keypad {
            return SEVEN
        }

        override fun left(): Keypad {
            return FIVE
        }
    },
    SEVEN {
        override fun down(): Keypad {
            return B
        }

        override fun up(): Keypad {
            return THREE
        }

        override fun right(): Keypad {
            return EIGHT
        }

        override fun left(): Keypad {
            return SIX
        }
    },
    EIGHT {
        override fun down(): Keypad {
            return C
        }

        override fun up(): Keypad {
            return FOUR
        }

        override fun right(): Keypad {
            return NINE
        }

        override fun left(): Keypad {
            return SEVEN
        }
    },
    NINE {
        override fun left(): Keypad {
            return EIGHT
        }
    },
    A {
        override fun up(): Keypad {
            return SIX
        }

        override fun right(): Keypad {
            return B
        }
    },
    B {
        override fun down(): Keypad {
            return D
        }

        override fun up(): Keypad {
            return SEVEN
        }

        override fun right(): Keypad {
            return C
        }

        override fun left(): Keypad {
            return A
        }
    },
    C {
        override fun up(): Keypad {
            return EIGHT
        }

        override fun left(): Keypad {
            return B
        }
    },
    D {
        override fun up(): Keypad {
            return B
        }
    };

    open fun up() : Keypad {
        return this
    }
    open fun left() : Keypad {
        return this
    }
    open fun right() : Keypad {
        return this
    }
    open fun down() : Keypad {
        return this
    }
}
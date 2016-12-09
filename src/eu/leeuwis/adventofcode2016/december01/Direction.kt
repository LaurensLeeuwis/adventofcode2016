package eu.leeuwis.adventofcode2016.december01

enum class Direction {
    NORTH {
        override fun right(): Direction {
            return EAST
        }

        override fun left(): Direction {
            return WEST
        }
    },
    EAST {
        override fun right(): Direction {
            return SOUTH
        }

        override fun left(): Direction {
            return NORTH
        }
    },
    SOUTH {
        override fun right(): Direction {
            return WEST
        }

        override fun left(): Direction {
            return EAST
        }
    },
    WEST {
        override fun right(): Direction {
            return NORTH
        }

        override fun left(): Direction {
            return SOUTH
        }
    };

    abstract fun right(): Direction;
    abstract fun left(): Direction;

}
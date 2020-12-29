package day11

enum class Filling(val symbol: Char) {
    FLOOR('.'),
    EMPTY_SEAT('L'),
    FILLED_SEAT('#');

    companion object {
        fun forSymbol(symbol: Char): Filling {
            return values().firstOrNull { symbol == it.symbol } ?: FLOOR
        }
    }

    override fun toString(): String {
        return "$symbol"
    }
}

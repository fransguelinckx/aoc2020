package day11

import day11.Filling.*
import kotlin.math.max

class Room {

    var fillings: Array<Array<Filling>> = arrayOf()

    constructor(stringRows: List<String>) {
        fillings = Array(stringRows.size) { Array(stringRows[0].count()) { FLOOR } }
        stringRows.mapIndexed { index, row -> parseRow(index, row) }
    }

    constructor(fillings: Array<Array<Filling>>) {
        this.fillings = fillings
    }

    private fun parseRow(rowNumber: Int, stringRow: String) {
        stringRow.toCharArray()
            .mapIndexed { index, symbol -> fillings[rowNumber][index] = Filling.forSymbol(symbol) }
    }

    fun numberOfEmptyAdjecentSeats(x: Int, y: Int): Int {
        var result = 0
        for (i in x - 1..x + 1) {
            for (j in y - 1..y + 1) {
                if ((i != x || j != y) && isSeatEmpty(i, j)) {
                    result++
                }
            }
        }
        return result
    }

    fun numberOfVisibleOccupiedAdjecentSeats(x: Int, y: Int): Int {
        var result = 0
        for (i in -1..1) {
            for (j in -1..1) {
                if ((i != 0 || j != 0) && seesOccupiedSeat(x, y, i, j)) {
                    result++
                }
            }
        }
        return result
    }

    private fun seesOccupiedSeat(x: Int, y: Int, xDifference: Int, yDifference: Int): Boolean {
        for (i in 1..max(fillings.size, fillings[0].size)) {
            val xToCheck = x + (i * xDifference)
            val yToCheck = y + (i * yDifference)
            if (xToCheck >= 0 && xToCheck < fillings[0].size) {
                if (yToCheck >= 0 && yToCheck < fillings.size) {
                    if (fillings[yToCheck][xToCheck] == FILLED_SEAT) {
                        return true
                    } else if (fillings[yToCheck][xToCheck] == EMPTY_SEAT) {
                        return false
                    }
                }
            }
        }
        return false
    }

    private fun isSeatEmpty(x: Int, y: Int): Boolean {
        if (x < 0 || y < 0 || x >= fillings.size || y >= fillings[0].size) {
            return true
        }
        return fillings[x][y] == EMPTY_SEAT || fillings[x][y] == FLOOR
    }

    fun nextState(): Room {
        val newFillings: Array<Array<Filling>> = copy()
        for (x in fillings[0].indices) {
            for (y in fillings.indices) {
                newFillings[y][x] = Rule.values()
                    .firstOrNull { it.isApplicable(fillings[y][x], numberOfVisibleOccupiedAdjecentSeats(x, y)) }
                    ?.newFilling
                    ?: fillings[y][x]
            }
        }
        return Room(newFillings)
    }

    private fun copy(): Array<Array<Filling>> {
        val newFillings: Array<Array<Filling>> = Array(fillings.size) { Array(fillings[0].count()) { FLOOR } }
        for (x in fillings.indices) {
            for (y in fillings[x].indices) {
                newFillings[x][y] = fillings[x][y]
            }
        }
        return newFillings
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Room

        if (!fillings.contentDeepEquals(other.fillings)) return false

        return true
    }

    override fun hashCode(): Int {
        return fillings.contentDeepHashCode()
    }

    override fun toString(): String {
        return this.fillings
            .map { it -> it.map { it.toString() }.joinToString("", "", "", -1, "...") { it } }
            .joinToString { it + "\n" }
    }

}

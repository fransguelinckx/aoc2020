package day14

import java.math.BigInteger
import java.math.BigInteger.ZERO

class Bit36 {

    private val MAX_BIT_POSITION = 35
    private var bitString: String

    constructor(bitString: String) {
        this.bitString = bitString
    }

    constructor(number: Int) {
        var result = ""
        var remainder = number.toBigInteger()
        for (position in MAX_BIT_POSITION downTo 0) {
            if (remainder >= BigInteger.valueOf(2).pow(position)) {
                result += "1"
                remainder -= BigInteger.valueOf(2).pow(position)
            } else {
                result += "0"
            }
        }
        this.bitString = result
    }

    fun applyMask(mask: Mask): Bit36 {
        var result = ""
        for (position in MAX_BIT_POSITION downTo 0) {
            if (mask.charAtPosition(position) == 'X') {
                result += bitString.toCharArray()[position]
            } else {
                result += mask.charAtPosition(position)
            }
        }
        this.bitString = result
        return this
    }

    fun applyMask2(mask: Mask): List<Bit36> {
        var results = mutableListOf<String>()
        for (position in 0..MAX_BIT_POSITION) {
            if (mask.charAtPosition(position) == 'X') {
                if (results.isEmpty()) {
                    results.add("0")
                    results.add("1")
                } else {
                    var copy1 = results.toMutableList()
                    var copy2 = results.toMutableList()
                    copy1 = copy1.map { it + "0" }.toMutableList()
                    copy2 = copy2.map { it + "1" }.toMutableList()
                    copy1.addAll(copy2)
                    results = copy1
                }
            } else if (mask.charAtPosition(position) == '0') {
                if (results.isEmpty()) {
                    results.add(this.bitString.toCharArray()[position].toString())
                } else {
                    results = results.map { it + this.bitString.toCharArray()[position] }
                        .toMutableList()
                }
            } else {
                if (results.isEmpty()) {
                    results.add("1")
                } else {
                    results = results.map { it + '1' }
                        .toMutableList()
                }
            }
        }
        return results.map { Bit36(it) }
    }

    fun toBigInt(): BigInteger {
        var result = ZERO
        for (position in 0..MAX_BIT_POSITION) {
            if (this.bitString.toCharArray()[position] == '1') {
                result = result.plus(BigInteger.valueOf(2).pow(35-position))
            }
        }
        return result
    }
}

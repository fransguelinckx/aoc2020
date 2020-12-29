package day9

import java.io.File
import java.math.BigInteger
import java.math.BigInteger.ZERO

fun main(args: Array<String>) {
    val numbers = File("src/main/resources/" + args[0])
        .readLines()
        .filter { it.isNotEmpty() }
        .map { BigInteger(it) }

    val permutations = numbers
        .windowed(25)
        .map { permutatedSumsOf(it) }

    println(numbers.size)
    println(numbers.drop(25).size)

    val weakness = numbers
        .drop(25)
        .filterIndexed { index, bigInteger -> !permutations[index].contains(bigInteger) }
        .first()
    println(weakness)

    println(lookForWeakSum(numbers, weakness))

}

fun lookForWeakSum(numbers: List<BigInteger>, sum: BigInteger): BigInteger {
    for (index in numbers.indices) {
        var runningSum: BigInteger = numbers[index]
        for (secondIndex in index + 1 until numbers.size) {
            runningSum += numbers[secondIndex]
            if (runningSum == sum) {
                val min = numbers.subList(index, secondIndex).minOrNull() ?: ZERO
                val max = numbers.subList(index, secondIndex).maxOrNull() ?: ZERO
                return min.plus(max)
            } else if (runningSum > sum) {
                break
            }
        }
    }
    return ZERO
}

fun permutatedSumsOf(numbers: List<BigInteger>): MutableSet<BigInteger> {
    val permutations = mutableSetOf<BigInteger>()
    for (index in numbers.indices) {
        for (secondIndex in index until numbers.size)
            if (numbers[index] != numbers[secondIndex]) {
                permutations.add(numbers[index] + numbers[secondIndex])
            }
    }
    return permutations
}

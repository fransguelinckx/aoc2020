package day10

import java.io.File
import java.math.BigInteger

fun main(args: Array<String>) {
    val adapters = File("src/main/resources/" + args[0])
        .readLines()
        .filter { it.isNotEmpty() }
        .map { it.toInt() }
        .sorted()
        .toMutableList()
    adapters
        .add(0, 0)

    println(adapters)
//    val slidingWindows = adapters.windowed(2, 1, false)
//    println(slidingWindows)
//    val differences = slidingWindows.map { it[1] - it[0] }
//    println(differences)
//    println((differences.count { it == 1 } + 1) * (differences.count { it == 3 } + 1))
//
//    println(differences.count())

    val numberOfPossibilities = Array<BigInteger>(150) { BigInteger.ZERO }
    numberOfPossibilities[0] = BigInteger.ONE

    for (adapter in adapters) {
        for (difference in 1..3) {
            val nextAdapter = adapter + difference
            if (adapters.contains(nextAdapter)) {
                numberOfPossibilities[nextAdapter] += numberOfPossibilities[adapter]
            }
        }
    }

    println("solution")
    println(numberOfPossibilities[149])
}

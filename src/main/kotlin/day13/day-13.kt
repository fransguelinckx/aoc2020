package day13

import java.io.File
import java.math.BigInteger
import java.math.BigInteger.ZERO

fun main(args: Array<String>) {

//    val earliestTimestamp = File("src/main/resources/" + args[0])
//        .readLines()
//        .first()
//        .toInt()
//
//    val shuttle = File("src/main/resources/" + args[0])
//        .readLines()
//        .last()
//        .split(",")
//        .filter { it != "x" }
//        .map { it.toInt() }
//        .map { Pair(it, earliestPossibleDeparture(it, earliestTimestamp)) }
//        .minByOrNull { it.second }
//
//    println(
//        shuttle?.first?.times(shuttle.second.minus(earliestTimestamp))
//    )

    val shuttles = File("src/main/resources/" + args[0])
        .readLines()
        .last()
        .split(",")
        .mapIndexed { index, it -> Pair(it, index) }
        .filter { it.first != "x" }
        .map { Pair(it.first.toBigInteger(), it.second) }


    var step = shuttles.first().first
    var time = shuttles.first().first
    shuttles.drop(1)

    for (shuttle in shuttles.drop(1)) {
        while ((time + shuttle.second.toBigInteger()).mod(shuttle.first) != ZERO) {
            time = time.plus(step)
        }
        step = step.multiply(shuttle.first)
    }
    println(time)

}

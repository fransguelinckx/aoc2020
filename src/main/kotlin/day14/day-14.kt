package day14

import java.io.File
import java.math.BigInteger

fun main(args: Array<String>) {

    val lines = File("src/main/resources/" + args[0])
        .readLines()

//    var memory = MutableList(99999) { BigInteger.ZERO }
//
//    var currentMask: Mask = Mask("")
//    for (line in lines) {
//        if (line.startsWith("mask = ")) {
//            currentMask = Mask(line.drop(7))
//        } else {
//            val position: Int = line.drop(4).substringBefore("]").toInt()
//            memory[position] = Bit36(line.substringAfterLast(" ").toInt()).applyMask(currentMask).toBigInt()
//        }
//    }
//
//    println(
//        memory.reduce { one, two -> one.plus(two) }
//    )


    var memory = mutableMapOf<BigInteger, BigInteger>()

    var currentMask: Mask = Mask("")
    for (line in lines) {
        if (line.startsWith("mask = ")) {
            currentMask = Mask(line.drop(7))
        } else {
            val position: Int = line.drop(4).substringBefore("]").toInt()
            Bit36(position).applyMask2(currentMask)
                .forEach { memory[it.toBigInt()] = line.substringAfterLast(" ").toBigInteger() }
        }
    }

    println(
        memory.values.reduce { one, two ->
            one.plus(
                two
            )
        }
    )
}

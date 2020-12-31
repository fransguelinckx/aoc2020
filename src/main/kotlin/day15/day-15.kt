package day15

import java.io.File

fun main(args: Array<String>) {

    val startingNumbers = File("src/main/resources/day-15-input.txt")
        .readLines()
        .first()
        .split(",")
        .toMutableList()
    val size = startingNumbers.size

//    for (index in size until 2020) {
//        val lastSpokenNumber = startingNumbers[index - 1]
//        val lastIndex = startingNumbers.dropLast(1).lastIndexOf(lastSpokenNumber)
//        if (lastIndex == -1) {
//            startingNumbers.add("0")
//        } else {
//            startingNumbers.add((index - lastIndex - 1).toString())
//        }
//    }

//    println(startingNumbers)
//    println(startingNumbers.last())

    val startingNumbersMap = startingNumbers
        .mapIndexed { index, s -> s.toInt() to mutableListOf(index) }
        .toMap()
        .toMutableMap()

    var lastSpokenNumber = startingNumbers.last().toInt()

    for (index in size until 30000000) {
        if (startingNumbersMap[lastSpokenNumber]?.size ?: 0 > 1) {
            val value = startingNumbersMap[lastSpokenNumber]!!.last() - startingNumbersMap[lastSpokenNumber]!!.dropLast(1).last()
            lastSpokenNumber = value
        } else {
            lastSpokenNumber = 0
        }

        if (startingNumbersMap.containsKey(lastSpokenNumber)) {
            startingNumbersMap[lastSpokenNumber]!!.add(index)
        } else {
            startingNumbersMap[lastSpokenNumber] = mutableListOf(index)
        }
        startingNumbersMap[lastSpokenNumber] = startingNumbersMap[lastSpokenNumber]!!.takeLast(2).toMutableList()

        if (index % 100000 == 0) {
            println(index)
        }
    }

    println(lastSpokenNumber)

}

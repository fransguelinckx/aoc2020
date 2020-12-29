package day1

import java.io.File

fun main(args: Array<String>) {
    val expenses = File("src/main/resources/" + args[0])
        .readLines()
        .map { it.toInt() }

    expenses.map { expense1 -> expenses.map { expense2 -> Triple(expense1 + expense2, expense1, expense2) } }
        .flatten()
        .map { partialSum -> expenses.map { expense -> Pair(partialSum.first + expense, Triple(expense, partialSum.second, partialSum.third)) } }
        .flatten()
        .filter { pair -> pair.first == 2020 }
        .map { pair -> pair.second }
        .map { triple -> triple.first * triple.second * triple.third }
        .distinct()
        .forEach(::println)
}

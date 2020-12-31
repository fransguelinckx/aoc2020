package day16

import java.io.File

fun main() {

    val rules = File("src/main/resources/day-16-input.txt")
        .readLines()
        .asSequence()
        .takeWhile { it != "your ticket:" }
        .filter { it.isNotEmpty() }
        .map { it.replace(" ", "") }
        .map { Pair(it.substringBefore(":"), it.substringAfter(":")) }
        .map { Pair(it.first, it.second.split("or")) }
        .map { Pair(it.first, it.second.map { range -> IntRange(range.substringBefore("-").toInt(), range.substringAfter("-").toInt()) }) }
        .toMutableList()

    val nearbyTickets = File("src/main/resources/day-16-input.txt")
        .readLines()
        .asSequence()
        .dropWhile { it != "nearby tickets:" }
        .drop(1)
        .map { it.split(",") }
        .map { list -> list.map { it.toInt() } }
        .filter { ticket -> ticket.all { field -> rules.any { rule -> rule.second.any { range -> range.contains(field) } } } }
        .toList()

    val yourTicket = File("src/main/resources/day-16-input.txt")
        .readLines()
        .dropWhile { it != "your ticket:" }
        .drop(1)
        .first()
        .split(",")


//    println(rules)
//    println(yourTicket)
//    println(nearbyTickets)
    val ticketSize = yourTicket.size
    val orderedRules = MutableList(20) { Pair("", listOf<IntRange>()) }

    while (rules.isNotEmpty()) {
        for (index in 0 until ticketSize) {
            val firstFields = nearbyTickets.map { it[index] }
            val validRules = rules.filter { rule -> firstFields.all { rule.second.any { range -> range.contains(it) } } }
            if (validRules.size == 1) {
                orderedRules[index] = validRules.first()
                rules.remove(validRules.first())
                break
            }
        }
    }

    println(
        orderedRules
            .mapIndexed { index, pair -> Pair(pair.first, index) }
            .filter { it.first.startsWith("departure") }
            .map { yourTicket[it.second].toBigInteger() }
            .reduce { acc, s -> acc * s }
    )
}

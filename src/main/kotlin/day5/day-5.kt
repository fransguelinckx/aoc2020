package day4

import day5.SeatLocator
import java.io.File

fun main(args: Array<String>) {
    println(
        File("src/main/resources/" + args[0])
            .readLines()
            .filter { it.isNotEmpty() }
            .map { SeatLocator.locateSeat(it) }
            .maxOrNull()
    )

    val seats = File("src/main/resources/" + args[0])
        .readLines()
        .filter { it.isNotEmpty() }
        .map { SeatLocator.locateSeat(it) }

    val maxNumberOfSeats = seats.maxOrNull() ?: 1

    println(IntRange(0, maxNumberOfSeats)
        .first { seats.contains(it - 1) && seats.contains(it + 1) && !seats.contains(it) })
}

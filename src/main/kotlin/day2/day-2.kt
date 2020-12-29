package day2

import java.io.File

fun main(args: Array<String>) {
    println(
        File("src/main/resources/" + args[0])
            .readLines()
            .map { it.split(": ") }
            .filter { it.size == 2 }
            .map { FirstPasswordPolicy(it[0]).appliesTo(it[1]) }
            .count { it })

    println(
        File("src/day4.day3.day2.day1.main/resources/" + args[0])
            .readLines()
            .map { it.split(": ") }
            .filter { it.size == 2 }
            .map { SecondPasswordPolicy(it[0]).appliesTo(it[1]) }
            .count { it })
}

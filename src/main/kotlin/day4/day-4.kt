package day4

import java.io.File

fun main(args: Array<String>) {
    println(
        File("src/main/resources/" + args[0])
            .readText()
            .split("\n\n")
            .filter { it.isNotEmpty() }
            .map { Passport(it) }
            .count { it.isValid() }
    )
}

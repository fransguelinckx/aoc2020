package day6

import java.io.File

fun main(args: Array<String>) {
    println(
        File("src/main/resources/" + args[0])
            .readText()
            .split("\n\n")
            .filter { it.isNotEmpty() }
            .map { GroupAnswers(it).numberOfUniqueAnswers() }
            .sum()
    )

    println(
        File("src/main/resources/" + args[0])
            .readText()
            .split("\n\n")
            .filter { it.isNotEmpty() }
            .map { it.trim() }
            .map { GroupAnswers(it).numberOfPositiveAnswersForWholeGroup() }
            .sum()
    )
}

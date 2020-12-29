package day7

import java.io.File

fun main(args: Array<String>) {
    val rules = File("src/main/resources/" + args[0])
        .readLines()
        .filter { it.isNotEmpty() }
        .map { RuleParser.parse(it) }
        .associateBy { it.name }

    println(
        rules
            .filter { it.value.canContain("shiny gold", rules) }
            .count()
    )

    println(
        rules["shiny gold"]?.numberOfContainingBags(rules))
}

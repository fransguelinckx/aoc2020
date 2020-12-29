package day8

import java.io.File

fun main(args: Array<String>) {
    val instructions = File("src/main/resources/" + args[0])
        .readLines()
        .filter { it.isNotEmpty() }
        .map { Instruction(it) }

    val instructionSet = InstructionSet(instructions)
    println(instructionSet.execute())

    val mutatedInstructionSets = mutableSetOf<InstructionSet>()

    for (position in instructions.indices) {
        mutatedInstructionSets.add(instructionSet.flipAtPosition(position))
    }

    println(mutatedInstructionSets.size)

    println(
        mutatedInstructionSets
            .mapNotNull { it.execute() }
            .first()
    )
}

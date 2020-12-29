package day8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InstructionSetTest {

    private val stringInstructions = """nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6"""

    @Test
    internal fun instructionSet() {
        val instructions = stringInstructions
            .lines()
            .filter { it.isNotEmpty() }
            .map { Instruction(it) }

        assertThat(InstructionSet(instructions).execute()).isEqualTo(5)
    }

    @Test
    internal fun instruction_equals() {
        val instructions1 = stringInstructions
            .lines()
            .filter { it.isNotEmpty() }
            .map { Instruction(it) }
        val instructions2 = stringInstructions
            .lines()
            .filter { it.isNotEmpty() }
            .map { Instruction(it) }

        assertThat(InstructionSet(instructions1)).isEqualTo(InstructionSet(instructions2))
    }
}

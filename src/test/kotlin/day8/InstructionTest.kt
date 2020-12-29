package day8

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InstructionTest {

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
    internal fun instruction() {
        assertThat(Instruction("acc -99").argument).isEqualTo(-99)
        assertThat(Instruction("acc +6").argument).isEqualTo(6)
    }
}

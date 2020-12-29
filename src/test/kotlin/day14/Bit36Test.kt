package day14

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class Bit36Test {

    @Test
    internal fun toBit32() {
        assertThat(Bit36(101).toBit36()).isEqualTo("000000000000000000000000000001100101")
    }

    @Test
    internal fun applyMask() {
        Bit36(101).applyMask(Mask("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X"))
    }
}

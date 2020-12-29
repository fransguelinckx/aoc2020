package day12

import day12.Rotation.QUARTER
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RotationTest {

    @Test
    internal fun quarter() {
        assertThat(QUARTER.xCoordinate(10, 4)).isEqualTo(4)
        assertThat(QUARTER.yCoordinate(10, 4)).isEqualTo(-10)
    }
}

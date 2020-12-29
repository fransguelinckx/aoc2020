package day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PositionLocatorTest {

    @Test
    internal fun findPositionForCode() {
        assertThat(PositionLocator(128, 'F', 'B').findPositionForCode("FBFBBFF")).isEqualTo(44)
        assertThat(PositionLocator(128, 'F', 'B').findPositionForCode("BFFFBBF")).isEqualTo(70)
        assertThat(PositionLocator(128, 'F', 'B').findPositionForCode("FFFBBBF")).isEqualTo(14)
        assertThat(PositionLocator(128, 'F', 'B').findPositionForCode("BBFFBBF")).isEqualTo(102)

        assertThat(PositionLocator(8, 'L', 'R').findPositionForCode("RRR")).isEqualTo(7)
        assertThat(PositionLocator(8, 'L', 'R').findPositionForCode("RLL")).isEqualTo(4)
    }
}

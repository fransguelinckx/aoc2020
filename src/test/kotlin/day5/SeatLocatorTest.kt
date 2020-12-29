package day5

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SeatLocatorTest {

    @Test
    fun locateSeat() {
        assertThat(SeatLocator.locateSeat("BFFFBBFRRR")).isEqualTo(567)
        assertThat(SeatLocator.locateSeat("FFFBBBFRRR")).isEqualTo(119)
        assertThat(SeatLocator.locateSeat("BBFFBBFRLL")).isEqualTo(820)
    }
}

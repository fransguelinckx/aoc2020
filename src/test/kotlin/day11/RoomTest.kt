package day11

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RoomTest {
    val room1: String = """L.LL.LL.LL
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL"""
    val room2: String = """L.LL.LL.L.
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL"""
    val room3: String = """L#LL.LL.L.
#.LLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL##
L.LLLLL.LL"""
    val room4: String = """L#LL.LL.L."""
    val room5: String = """L.LL.LL.LL
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL"""
    val room6: String = """#.##.##.##
#######.##
#.#.#..#..
####.##.##
#.##.##.##
#.#####.##
..#.#.....
##########
#.######.#
#.#####.##"""
    val room7: String = """#.LL.LL.L#
#LLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLL#
#.LLLLLL.L
#.LLLLL.L#"""
    val room8: String = """#.L#.##.L#
#L#####.LL
L.#.#..#..
##L#.##.##
#.##.#L.##
#.#####.#L
..#.#.....
LLL####LL#
#.L#####.L
#.L####.L#"""
    val room9: String = """.......#.
...#.....
.#.......
.........
..#L....#
....#....
.........
#........
...#....."""

    @Test
    internal fun equals() {
        assertThat(Room(room1.lines())).isEqualTo(Room(room1.lines()))
        assertThat(Room(room1.lines())).isNotEqualTo(Room(room2.lines()))
    }

    @Test
    internal fun numberOfEmptyAdjecentSeats() {
        assertThat(Room(room1.lines()).numberOfEmptyAdjecentSeats(0, 0)).isEqualTo(8)
        assertThat(Room(room1.lines()).numberOfEmptyAdjecentSeats(0, 0)).isEqualTo(8)
        assertThat(Room(room3.lines()).numberOfEmptyAdjecentSeats(0, 0)).isEqualTo(6)
        assertThat(Room(room3.lines()).numberOfEmptyAdjecentSeats(1, 1)).isEqualTo(6)
        assertThat(Room(room3.lines()).numberOfEmptyAdjecentSeats(9, 9)).isEqualTo(6)
        assertThat(Room(room3.lines()).numberOfEmptyAdjecentSeats(8, 8)).isEqualTo(7)
        assertThat(Room(room4.lines()).numberOfEmptyAdjecentSeats(0, 2)).isEqualTo(7)
        assertThat(Room(room4.lines()).numberOfEmptyAdjecentSeats(0, 9)).isEqualTo(8)
    }

    @Test
    internal fun numberOfOccupiedAdjecentSeats() {
        assertThat(Room(room9.lines()).numberOfVisibleOccupiedAdjecentSeats(3, 4)).isEqualTo(8)
    }

    @Test
    internal fun nextState() {
        assertThat(Room(room5.lines()).nextState()).isEqualTo(Room(room6.lines()))
        assertThat(Room(room6.lines()).nextState()).isEqualTo(Room(room7.lines()))
        assertThat(Room(room7.lines()).nextState()).isEqualTo(Room(room8.lines()))
    }
}


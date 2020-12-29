package day5

class SeatLocator {
    companion object {
        val rowLocator = PositionLocator(128, 'F', 'B')
        val columnLocator = PositionLocator(8, 'L', 'R')

        fun locateSeat(seatCode: String): Int {
            val row = rowLocator.findPositionForCode(seatCode.take(7))
            val column = columnLocator.findPositionForCode(seatCode.takeLast(3))
            return row * 8 + column
        }
    }
}

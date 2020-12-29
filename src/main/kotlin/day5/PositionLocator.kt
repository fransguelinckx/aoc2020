package day5

class PositionLocator(val totalNumberOfRows: Int, val lowerHalfCharacter: Char, val upperHalfCharacter: Char) {

    fun findPositionForCode(code: String): Int {
        var rows: IntRange = IntRange(0, this.totalNumberOfRows - 1)
        code.toCharArray()
            .forEach {
                if (lowerHalfCharacter == it) {
                    rows = IntRange(rows.first, rows.last - (rows.count() / 2))
                } else if (upperHalfCharacter == it) {
                    rows = IntRange(rows.first + (rows.count() / 2), rows.last)
                }
            }
        if (rows.count() != 1) {
            throw Exception("KAPOW!")
        }
        return rows.first
    }

}

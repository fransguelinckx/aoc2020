package day12

enum class Rotation(val degrees: Int, val xCoordinate: (Int, Int) -> Int, val yCoordinate: (Int, Int) -> Int) {
    QUARTER(90, { _, y -> y }, { x, _ -> -x }),
    HALF(180, { x, _ -> -x }, { _, y -> -y }),
    THREE_QUARTERS(270, { _, y -> -y }, { x, _ -> x }),
    FULL(360, { _, y -> y }, { x, _ -> x });

    companion object {
        fun rotationForDegrees(degrees: Int): Rotation {
            return try {
                values()
                    .first { degrees % 360 == it.degrees }
            } catch (e: Exception) {
                println("degrees = [${degrees}]")
                throw e
            }
        }
    }
}

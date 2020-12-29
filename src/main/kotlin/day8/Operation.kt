package day8

enum class Operation(
    val positionModifier: (Int, Int) -> Int,
    val accumulatorModifier: (Int, Int) -> Int
) {

    ACC({ _, position -> position + 1 }, { argument, accumulator -> accumulator + argument }),
    JMP({ argument, position -> position + argument }, { _, accumulator -> accumulator }),
    NOP({ _, position -> position + 1 }, { _, accumulator -> accumulator });

    fun flip(): Operation {
        if (this == JMP) {
            return NOP
        }
        if (this == NOP) {
            return JMP
        }
        return ACC
    }

}

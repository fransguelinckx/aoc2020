package day8

class InstructionSet(val instructions: List<Instruction>) {

    var position = 0
    var accumulator = 0
    var numberOfInstructions = 0
    private val pastPositions = mutableSetOf<Int>()

    fun execute(): Int? {
        while (position != instructions.size) {
            val currentInstruction = instructions[position]
            accumulator = currentInstruction.accumulate(accumulator)
            pastPositions.add(position)
            val nextPosition = currentInstruction.nextPosition(position)
            if (pastPositions.contains(nextPosition)) {
                return null
            }
            position = nextPosition
            numberOfInstructions++
        }
        return accumulator
    }

    fun flipAtPosition(position: Int): InstructionSet {
        val modifiedInstructions = instructions.toMutableList()
        modifiedInstructions[position] = modifiedInstructions[position].oppositeInstruction()
        return InstructionSet(modifiedInstructions)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InstructionSet

        if (instructions != other.instructions) return false

        return true
    }

    override fun hashCode(): Int {
        return instructions.hashCode()
    }

}

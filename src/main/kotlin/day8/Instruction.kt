package day8

class Instruction {

    val operation: Operation
    val argument: Int

    constructor(stringInstruction: String) {
        this.operation = Operation.valueOf(stringInstruction.split(" ")[0].toUpperCase())
        this.argument = stringInstruction.split(" ")[1].toInt()
    }

    private constructor(operation: Operation, argument: Int) {
        this.operation = operation
        this.argument = argument
    }

    fun accumulate(accumulator: Int): Int {
        return operation.accumulatorModifier(argument, accumulator)
    }

    fun nextPosition(position: Int): Int {
        return operation.positionModifier(argument, position)
    }

    fun oppositeInstruction(): Instruction {
        return Instruction(operation.flip(), argument)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Instruction

        if (operation != other.operation) return false
        if (argument != other.argument) return false

        return true
    }

    override fun hashCode(): Int {
        var result = operation.hashCode()
        result = 31 * result + argument
        return result
    }

}

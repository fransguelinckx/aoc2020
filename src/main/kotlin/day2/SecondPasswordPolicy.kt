package day2

class SecondPasswordPolicy(policyAsString: String) {

    private var positions: Pair<Int, Int>
    private var character: Char

    init {
        val split = policyAsString.split(" ")
        val positions = split[0].split("-")
        this.character = split[1][0]
        this.positions = Pair(positions[0].toInt() - 1, positions[1].toInt() - 1)
    }

    fun appliesTo(password: String): Boolean {
        return (password.elementAt(positions.first) == this.character)
            .xor(
                password.elementAt(positions.second) == this.character
            )
    }
}

package day2

class FirstPasswordPolicy(policyAsString: String) {

    private var range: IntRange
    private var character: Char

    init {
        val split = policyAsString.split(" ")
        val range = split[0].split("-")
        this.range = IntRange(range[0].toInt(), range[1].toInt())
        this.character = split[1][0]
    }

    fun appliesTo(password: String): Boolean {
        return range.contains(password.count { character -> character == this.character })
    }
}

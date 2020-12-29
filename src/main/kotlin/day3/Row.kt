package day3

class Row(var pattern: String) {

    fun hasTreeAtPosition(position: Int): Boolean {
        return pattern.elementAt(position % this.pattern.length) == '#'
    }
}

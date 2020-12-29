package day14

class Mask(val mask: String) {

    fun charAtPosition(position: Int): Char {
        return mask.toCharArray()[position]
    }
}

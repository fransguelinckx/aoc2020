package day3

class Slope(pattern: List<String>) {

    var rows: List<Row> = pattern.map { Row(it) }

    fun numberOfTreesOnPath(stepsRight: Int, stepsDown: Int): Int {
        return rows
            .filterIndexed { index, _ -> index % stepsDown == 0 }
            .mapIndexed { index, row -> row.hasTreeAtPosition(index * stepsRight) }
            .count { it }
    }
}

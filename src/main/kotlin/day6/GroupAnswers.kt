package day6

class GroupAnswers(val answers: String) {

    fun numberOfUniqueAnswers(): Int {
        return answers
            .replace("\\s".toRegex(), "")
            .toSet()
            .count()
    }

    fun numberOfPositiveAnswersForWholeGroup(): Int {
        val lines = answers
            .lines()
        val reducedSet = lines
            .asSequence()
            .map { it.toCharArray() }
            .map { it.toSet() }
            .reduce { acc, set -> acc.intersect(set) }
        return reducedSet
            .count()
    }
}

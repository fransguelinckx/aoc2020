package day6

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupAnswersTest {

    private val GROUP_ANSWERS = """

abc

a
b
c

ab
ac

a 
a 
a 
a 

b

"""

    @Test
    fun numberOfPositiveAnswersForWholeGroup() {
        val sum = GROUP_ANSWERS
            .split("\n\n")
            .filter { it.isNotEmpty() }
            .map { it.trim() }
            .map { GroupAnswers(it).numberOfPositiveAnswersForWholeGroup() }
            .sum()
        assertThat(sum).isEqualTo(6)
    }
}

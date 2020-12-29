package day7

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RuleParserTest {

    @Test
    internal fun canContain() {
        val bag = RuleParser.parse("posh crimson bags contain 2 mirrored tan bags, 1 faded red bag, 1 striped gray bag.")
        assertThat(bag.canContain("mirrored tan", emptyMap())).isTrue
        assertThat(bag.canContain("faded red", emptyMap())).isTrue
        assertThat(bag.canContain("striped gray", emptyMap())).isTrue
        assertThat(bag.canContain("solid blue", emptyMap())).isFalse
    }

    @Test
    internal fun numberOfContainingBags() {
        val bag = RuleParser.parse("posh crimson bags contain 2 mirrored tan bags, 1 faded red bag, 1 striped gray bag.")
        assertThat(bag.numberOfContainingBags(emptyMap())).isEqualTo(4)
    }
}

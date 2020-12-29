package day7

class Rule(private val bags: Map<String, Int>, val name: String) {

    fun canContain(bagName: String, rules: Map<String, Rule>): Boolean {
        if (bags.containsKey(bagName)) {
            return true
        } else {
            return bags
                .any { rules[it.key]?.canContain(bagName, rules) ?: false }
        }
    }

    fun numberOfContainingBags(rules: Map<String, Rule>): Int {
        return bags
            .map { it.value }
            .sum() + bags
            .map { it.value * (rules[it.key]?.numberOfContainingBags(rules) ?: 0) }
            .sum()
    }
}

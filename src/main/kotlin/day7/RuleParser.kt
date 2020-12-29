package day7

class RuleParser() {

    companion object {
        fun parse(stringRule: String): Rule {
            val bags = Regex("(\\d+)\\s(\\w+\\s\\w+)\\sbags?[,|.]").findAll(stringRule)
                .associateBy({ it.destructured.component2() }, { it.destructured.component1().toInt() })
            val name = Regex("^(.*)\\sbags\\scontain").find(stringRule)!!.destructured.component1()
            return Rule(bags, name)
        }
    }
}

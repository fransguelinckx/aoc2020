package day4

enum class FieldType(private val required: Boolean, private val validate: (String) -> Boolean) {
    ECL(true, { eyeColors.contains(it) }),
    PID(true, { Regex("^[0-9]{9}$").matches(it) }),
    EYR(true, { IntRange(2020, 2030).contains(it.toInt()) }),
    HCL(true, { Regex("^#[0-9a-f]{6}$").matches(it) }),
    BYR(true, { IntRange(1920, 2002).contains(it.toInt()) }),
    IYR(true, { IntRange(2010, 2020).contains(it.toInt()) }),
    CID(false, { true }),
    HGT(true, {
        when {
            it.endsWith("cm") -> IntRange(150, 193).contains(it.dropLast(2).toInt())
            it.endsWith("in") -> IntRange(59, 76).contains(it.dropLast(2).toInt())
            else -> false
        }
    });

    companion object {
        val eyeColors: List<String> = listOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

        fun requiredFieldTypes(): List<FieldType> {
            return values()
                .filter { it.required }
        }

        fun isValidField(field: Pair<String, String>): Boolean {
            return valueOf(field.first.toUpperCase()).validate(field.second)
        }
    }

}

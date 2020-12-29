package day4

import day4.FieldType.Companion.requiredFieldTypes

class Passport(stringData: String) {

    private val fields: List<Pair<String, String>> = stringData
        .split(" ", "\n")
        .filter { it.isNotBlank() }
        .map { it.split(":") }
        .map { Pair(it[0], it[1]) }

    fun isValid(): Boolean {
        return requiredFieldTypes()
            .map { it.name.toLowerCase() }
            .minus(fields.map { it.first })
            .isEmpty()
                && fields.all { FieldType.isValidField(it) }
    }
}

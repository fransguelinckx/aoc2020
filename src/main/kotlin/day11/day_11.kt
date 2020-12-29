package day11

import java.io.File

fun main(args: Array<String>) {
    var firstRoom = Room(
        File("src/main/resources/" + args[0])
            .readLines()
    )
    while (firstRoom != firstRoom.nextState()) {
        firstRoom = firstRoom.nextState()
    }

    println(firstRoom.fillings
        .map { it.count { it == Filling.FILLED_SEAT } }
        .sum()
    )
}

package day12

import java.io.File
import kotlin.math.absoluteValue

fun main(args: Array<String>) {

    var horizontalPositionShip = 0
    var verticalPositionShip = 0
    var horizontalPositionWaypoint = 10
    var verticalPositionWaypoint = 1

    File("src/main/resources/" + args[0])
        .readLines()
        .map { Pair(Action.actionForSymbol(it.take(1)), it.drop(1).toInt()) }
        .forEach {
            val newHorizontalPositionWaypoint = it.first.horizontalPositionWaypoint(verticalPositionWaypoint, horizontalPositionWaypoint, it.second)
            val newVerticalPositionWaypoint = it.first.verticalPositionWaypoint(verticalPositionWaypoint, horizontalPositionWaypoint, it.second)
            horizontalPositionWaypoint = newHorizontalPositionWaypoint
            verticalPositionWaypoint = newVerticalPositionWaypoint

            horizontalPositionShip += it.first.horizontalDifferenceShip(horizontalPositionWaypoint, it.second)
            verticalPositionShip += it.first.verticalDifferenceShip(verticalPositionWaypoint, it.second)
        }

    println(horizontalPositionShip)
    println(verticalPositionShip)
    println(horizontalPositionWaypoint)
    println(verticalPositionWaypoint)

    println(horizontalPositionShip.absoluteValue + verticalPositionShip.absoluteValue)
}

package day3

import java.io.File

fun main(args: Array<String>) {
    val slope = Slope(File("src/main/resources/" + args[0]).readLines())

    val firstSlope = slope.numberOfTreesOnPath(1, 1)
    val secondSlope = slope.numberOfTreesOnPath(3, 1)
    val thirdSlope = slope.numberOfTreesOnPath(5, 1)
    val fourthSlope = slope.numberOfTreesOnPath(7, 1)
    val fifthSlope = slope.numberOfTreesOnPath(1, 2)

    println(firstSlope)
    println(secondSlope)
    println(thirdSlope)
    println(fourthSlope)
    println(fifthSlope)

    println(firstSlope.toBigInteger() * secondSlope.toBigInteger() * thirdSlope.toBigInteger() * fourthSlope.toBigInteger() * fifthSlope.toBigInteger())
}

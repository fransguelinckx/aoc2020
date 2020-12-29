package day12

class DegreesHelper {

    fun Degree.toRadian(): Radian = this / 180 * Math.PI
    fun Radian.toDegree(): Degree = this * 180 / Math.PI
}

typealias Radian = Double
typealias Degree = Double

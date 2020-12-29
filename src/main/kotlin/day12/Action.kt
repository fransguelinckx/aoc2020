package day12

import day12.Rotation.Companion.rotationForDegrees

enum class Action(
    var symbol: Char,
    var verticalPositionWaypoint: (verticalPosition: Int, horizontalPosition: Int, angle: Int) -> Int,
    var horizontalPositionWaypoint: (verticalPosition: Int, horizontalPosition: Int, angle: Int) -> Int,
    var verticalDifferenceShip: (verticalPositionWaypoint: Int, factor: Int) -> Int,
    var horizontalDifferenceShip: (horizontalPositionWaypoint: Int, factor: Int) -> Int
) {
    NORTH(
        'N',
        { verticalPosition, _, factor -> verticalPosition + factor },
        { _, horizontalPosition, _ -> horizontalPosition },
        { _, _ -> 0 },
        { _, _ -> 0 }),
    EAST(
        'E',
        { verticalPosition, _, _ -> verticalPosition },
        { _, horizontalPosition, factor -> horizontalPosition + factor },
        { _, _ -> 0 },
        { _, _ -> 0 }),
    SOUTH(
        'S',
        { verticalPosition, _, factor -> verticalPosition - factor },
        { _, horizontalPosition, _ -> horizontalPosition },
        { _, _ -> 0 },
        { _, _ -> 0 }),
    WEST(
        'W',
        { verticalPosition, _, _ -> verticalPosition },
        { _, horizontalPosition, factor -> horizontalPosition - factor },
        { _, _ -> 0 },
        { _, _ -> 0 }),
    LEFT(
        'L',
        { verticalPosition, horizontalPosition, angle -> rotationForDegrees(-angle + 360).yCoordinate(horizontalPosition, verticalPosition) },
        { verticalPosition, horizontalPosition, angle -> rotationForDegrees(-angle + 360).xCoordinate(horizontalPosition, verticalPosition) },
        { _, _ -> 0 },
        { _, _ -> 0 }),
    RIGHT(
        'R',
        { verticalPosition, horizontalPosition, angle -> rotationForDegrees(angle).yCoordinate(horizontalPosition, verticalPosition) },
        { verticalPosition, horizontalPosition, angle -> rotationForDegrees(angle).xCoordinate(horizontalPosition, verticalPosition) },
        { _, _ -> 0 },
        { _, _ -> 0 }),
    FORWARD(
        'F',
        { verticalPosition, _, _ -> verticalPosition },
        { _, horizontalPosition, _ -> horizontalPosition },
        { verticalPosition, factor -> verticalPosition * factor },
        { horizontalPosition, factor -> horizontalPosition * factor });

    companion object {
        fun actionForSymbol(symbol: String): Action {
            return values()
                .first { it.symbol == symbol[0] }
        }

        fun actionForAngle(angle: Int): Action {
            if ((angle + 360) % 360 == 0) {
                return NORTH
            } else if ((angle + 360) % 360 == 90) {
                return EAST
            } else if ((angle + 360) % 360 == 180) {
                return SOUTH
            } else if ((angle + 360) % 360 == 270) {
                return WEST
            } else {
                throw Exception("Weird angle")
            }
        }
    }
}

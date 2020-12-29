package day11

import day11.Filling.EMPTY_SEAT
import day11.Filling.FILLED_SEAT

enum class Rule(val isApplicable: (filling: Filling, numberOfOccupiedAdjecentSeats: Int) -> Boolean, val newFilling: Filling) {
//    FILL({ filling, numberOfEmptyAdjecentSeats -> filling == EMPTY_SEAT && numberOfEmptyAdjecentSeats == 8 }, FILLED_SEAT),
//    VACATE({ filling, numberOfEmptyAdjecentSeats -> filling == FILLED_SEAT && numberOfEmptyAdjecentSeats < 5 }, EMPTY_SEAT);
    FILL({ filling, numberOfOccupiedAdjecentSeats -> filling == EMPTY_SEAT && numberOfOccupiedAdjecentSeats == 0 }, FILLED_SEAT),
    VACATE({ filling, numberOfOccupiedAdjecentSeats -> filling == FILLED_SEAT && numberOfOccupiedAdjecentSeats >= 5 }, EMPTY_SEAT);
}

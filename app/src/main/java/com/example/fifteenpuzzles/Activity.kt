package com.example.fifteenpuzzles

import kotlin.math.abs

data class OutOfBoardException(val column: Int, val row: Int) : Exception()
data class IllegalMoveException(val dx: Int, val dy: Int) : Exception()

class Activity {
    private var _values: Array<Int> = arrayOf()

    var values: Array<Int>
        get() = _values
        set(update) {
            _values = update
        }

    private fun findEmpty(): Int {
        var holeIndex = 0
        while (values[holeIndex] != 0) {
            holeIndex++
        }
        return holeIndex
    }

    // firstCell- непустая  ячейка
    private fun swapHorizontally(
        firstCellColumn: Int,
        firstCellRow: Int,
        secondCellDistance: Int
    ) {
        val pointedCellIndex = firstCellColumn + 4 * firstCellRow
        val temp = values[pointedCellIndex]
        val holeCellIndex = pointedCellIndex + secondCellDistance
        values[pointedCellIndex] = values[holeCellIndex]
        values[holeCellIndex] = temp
    }

    private fun swapVertically(
        firstCellColumn: Int,
        firstCellRow: Int,
        secondCellDistance: Int
    ) {
        val pointedCellIndex = firstCellColumn + 4 * firstCellRow
        val temp = values[pointedCellIndex]
        val holeCellIndex = pointedCellIndex + 4 * secondCellDistance
        values[pointedCellIndex] = values[holeCellIndex]
        values[holeCellIndex] = temp
    }

    fun moveHoleToCell(column: Int, row: Int): Activity{
        val holeIndex = findEmpty()
        val holeColumn = holeIndex % 4
        val holeRow = holeIndex / 4
        val dx = column - holeColumn
        val dy = row - holeRow

        when {
            column == -1 || column == 4 -> throw OutOfBoardException(column = column, row = row)
            row == -1 || row == 4 -> throw OutOfBoardException(column = column, row = row)
            abs(dx) > 0 && abs(dy) > 0  ||  abs(dx) >= 2 || abs(dy) >= 2 -> throw IllegalMoveException(dx = dx, dy = dy)
            holeColumn != column -> swapHorizontally(
                firstCellColumn = column, firstCellRow = row, secondCellDistance = -dx
            )
            else -> swapVertically(
                firstCellColumn = column, firstCellRow = row,
                secondCellDistance = -dy
            )
        }

        return this
    }

    fun gameIsWon(): Boolean {
        val expectedOrder = arrayOf(
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, 12,
            13, 14, 15, 0
        )
        return values.contentEquals(expectedOrder)
        //contentEquals() — возвращает значение true только в том случае,
        // если эта строка представляет собой ту же последовательность символов

    }

}
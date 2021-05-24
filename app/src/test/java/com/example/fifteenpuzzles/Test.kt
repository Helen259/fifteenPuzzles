package com.example.fifteenpuzzles
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class ActivityTest {

    @Before
    fun setupBeforeEach(){
        data = Activity()
    }

    @Test
    fun tryingToBringTheHoleJustLeftToItsCell(){
        data.values = dataInit1
        data.moveHoleToCell(column = 0, row = 1)
        assertTrue(data.values.toIntArray().contentEquals(dataOutput1.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustLeftToItsCell2(){
        data.values = dataInit2
        data.moveHoleToCell(column = 1, row = 3)
        assertTrue(data.values.toIntArray().contentEquals(dataOutput2.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustRightToItsCell(){
        data.values = dataInit3
        data.moveHoleToCell(column = 2, row = 1)
        assertTrue(data.values.toIntArray().contentEquals(dataOutput3.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustRightToItsCell2(){
        data.values = dataInit4
        data.moveHoleToCell(column = 3, row = 0)
        assertTrue(data.values.toIntArray().contentEquals(dataOutput4.toIntArray()))
    }

    @Test
    fun tryingToBringTheHoleJustUpToItsCell(){
        data.values = dataInit5
        data.moveHoleToCell(column = 1, row = 0)
        assertTrue(data.values.toIntArray().contentEquals(dataOutput5.toIntArray()))
    }


    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHole(){
        data.values = dataInit1
        data.moveHoleToCell(column = 2, row = 2)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHole2(){
        data.values = dataInit2
        data.moveHoleToCell(column = 3, row = 2)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleF3(){
        data.values = dataInit4
        data.moveHoleToCell(column = 1, row = 1)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHole4(){
        data.values = dataOutput3
        data.moveHoleToCell(column = 0, row = 3)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt(){
        data.values = dataInit1
        data.moveHoleToCell(column = 3, row = 1)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt2(){
        data.values = dataOutput1
        data.moveHoleToCell(column = 3, row = 1)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt3(){
        data.values = dataOutput4
        data.moveHoleToCell(column = 0, row = 0)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt5(){
        data.values = dataOutput2
        data.moveHoleToCell(column = 1, row = 1)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt6(){
        data.values = dataInit1
        data.moveHoleToCell(column = 1, row = 3)
    }

    @Test(expected = IllegalMoveException::class)
    fun cannotBringTheHoleOnACellFarAwayFromIt7(){
        data.values = dataOutput4
        data.moveHoleToCell(column = 3, row = 3)
    }


    @Test(expected = OutOfBoardException::class)
    fun cannotMoveTheHoleOutOfBoard(){
        data.values = dataOutput1
        data.moveHoleToCell(column = -1, row = 1)
    }

    @Test(expected = OutOfBoardException::class)
    fun cannotMoveTheHoleOutOfBoard2(){
        data.values = dataOutput4
        data.moveHoleToCell(column = 4, row = 0)
    }

    @Test(expected = OutOfBoardException::class)
    fun cannotMoveTheHoleOutOfBoard3(){
        data.values = dataInit4
        data.moveHoleToCell(column = 2, row = -1)
    }

    @Test(expected = OutOfBoardException::class)
    fun cannotMoveTheHoleOutOfBoard4(){
        data.values = dataInit2
        data.moveHoleToCell(column = 2, row = 4)
    }

    @Test
    fun gameWon(){
        data.values = expectedOrder
        assertTrue(data.gameIsWon())
    }

    private lateinit var data: Activity

    private val expectedOrder = arrayOf(
        1,2,3,4,
        5,6,7,8,
        9,10,11,12,
        13,14,15,0
    )

    private val dataInit1 = arrayOf(
        4, 1, 12,7,
        3, 0, 8, 6,
        10, 15, 2, 11,
        14, 5, 13, 9
    )

    private val dataOutput1 = arrayOf(
        4, 1, 12, 7,
        0, 3, 8, 6,
        10, 15, 2, 11,
        14, 5, 13, 9
    )

    private val dataInit2 = arrayOf(
        4, 1, 12,7,
        3, 13, 8, 6,
        10, 15, 2, 11,
        14, 5, 0, 9
    )

    private val dataOutput2 = arrayOf(
        4, 1, 12, 7,
        3, 13, 8, 6,
        10, 15, 2, 11,
        14, 0, 5, 9
    )

    private val dataInit3 = arrayOf(
        8, 15, 3, 2,
        14, 0, 13, 7,
        1, 5, 9, 6,
        12, 4, 11, 10
    )

    private val dataOutput3 = arrayOf(
        8, 15, 3, 2,
        14, 13, 0, 7,
        1, 5, 9, 6,
        12, 4, 11, 10
    )

    private val dataInit4 = arrayOf(
        8, 15, 0, 2,
        14, 3, 13, 7,
        1, 5, 9, 6,
        12, 4, 11, 10
    )

    private val dataOutput4 = arrayOf(
        8, 15, 2, 0,
        14, 3, 13, 7,
        1, 5, 9, 6,
        12, 4, 11, 10
    )

    private val dataInit5 = arrayOf(
        4, 1, 12,7,
        3, 0, 8, 6,
        10, 15, 2, 11,
        14, 5, 13, 9
    )

    private val dataOutput5 = arrayOf(
        4, 0, 12,7,
        3, 1, 8, 6,
        10, 15, 2, 11,
        14, 5, 13, 9
    )

}
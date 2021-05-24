package com.example.fifteenpuzzles

import java.util.*

object Shuffling {
    private var placeHolder = (0..15).toMutableList()

    fun shuffle(): Array<Int> {
        val rand = Random()
        do {
            var count = 15
            while (count > 1) {
                val r = rand.nextInt(count--)
                val tmp = placeHolder[r]
                placeHolder[r] = placeHolder[count]
                placeHolder[count] = tmp
            }
        } while (!isSolvable())
        return placeHolder.toTypedArray()
    }

    private fun isSolvable(): Boolean {
        var countInversions = 0
        for (i in 0 until 15) {
            if (placeHolder[i + 1] > placeHolder[i]) countInversions++
        }
        return countInversions % 2 == 0
    }

}

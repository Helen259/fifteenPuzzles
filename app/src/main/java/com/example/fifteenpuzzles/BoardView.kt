package com.example.fifteenpuzzles
 import androidx.lifecycle.LiveData
 import androidx.lifecycle.MutableLiveData
 import androidx.lifecycle.ViewModel

class BoardView : ViewModel() {
    private val gridValues = MutableLiveData<Array<Int>>()
    private val dataGrid = Activity()
    private var gameFinished = true

    fun getGridValues() : LiveData<Array<Int>> {
        return gridValues
    }

    fun moveHoleToCell(column: Int, row: Int) {
        dataGrid.moveHoleToCell(column = column, row = row)
        gridValues.value = dataGrid.values
    }

    fun checkForWonGame(): Boolean {
        val wonGame = dataGrid.gameIsWon()
        if (wonGame) gameFinished = true
        return wonGame
    }

    fun randomizeGrid() {
        if (gameFinished){
                val newValues = Shuffling.shuffle();
                dataGrid.values = newValues
                gridValues.value = newValues
                gameFinished = false
        }
    }
}
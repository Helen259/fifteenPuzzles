package com.example.fifteenpuzzles

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("PLUGIN_WARNING")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(BoardView::class.java)
        viewModel.getGridValues().observe(this, Observer {
            if (it != null) {
                update(view11, it[0])
                update(view12, it[1])
                update(view13, it[2])
                update(view14, it[3])

                update(view21, it[4])
                update(view22, it[5])
                update(view23, it[6])
                update(view24, it[7])

                update(view31, it[8])
                update(view32, it[9])
                update(view33, it[10])
                update(view34, it[11])

                update(view41, it[12])
                update(view42, it[13])
                update(view43, it[14])
                update(view44, it[15])
            }
        })
        viewModel.randomizeGrid()

        view11.setOnClickListener { moveHoleToCell(column = 0, row = 0) }
        view12.setOnClickListener { moveHoleToCell(column = 1, row = 0) }
        view13.setOnClickListener { moveHoleToCell(column = 2, row = 0) }
        view14.setOnClickListener { moveHoleToCell(column = 3, row = 0) }

        view21.setOnClickListener { moveHoleToCell(column = 0, row = 1) }
        view22.setOnClickListener { moveHoleToCell(column = 1, row = 1) }
        view23.setOnClickListener { moveHoleToCell(column = 2, row = 1) }
        view24.setOnClickListener { moveHoleToCell(column = 3, row = 1) }

        view31.setOnClickListener { moveHoleToCell(column = 0, row = 2) }
        view32.setOnClickListener { moveHoleToCell(column = 1, row = 2) }
        view33.setOnClickListener { moveHoleToCell(column = 2, row = 2) }
        view34.setOnClickListener { moveHoleToCell(column = 3, row = 2) }

        view41.setOnClickListener { moveHoleToCell(column = 0, row = 3) }
        view42.setOnClickListener { moveHoleToCell(column = 1, row = 3) }
        view43.setOnClickListener { moveHoleToCell(column = 2, row = 3) }
        view44.setOnClickListener { moveHoleToCell(column = 3, row = 3) }

        newGame.setOnClickListener {
            viewModel.randomizeGrid()
            newGame.visibility = View.INVISIBLE
            board.visibility = View.VISIBLE
        }

        newGame.visibility = View.INVISIBLE
        board.visibility = View.VISIBLE
    }

    private lateinit var viewModel: BoardView

    private fun moveHoleToCell(column: Int, row: Int) {
        try {
            viewModel.moveHoleToCell(column = column, row = row)
            if (viewModel.checkForWonGame()) {
                Toast.makeText(this, R.string.you_won, Toast.LENGTH_SHORT).show()
                newGame.visibility = View.VISIBLE
                board.visibility = View.INVISIBLE
            }
        } catch (ex: IllegalMoveException) {
        }
    }

    private fun update(cellView: TextView, value: Int) {
        cellView.text = if (value > 0) value.toString() else ""
    }

}
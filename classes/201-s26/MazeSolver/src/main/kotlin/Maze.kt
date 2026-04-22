import java.io.File

open class Maze(filename: String) {

    // Rows and columns in the maze
    var numRows: Int
    var numCols: Int

    //Grid coordinates for the starting maze square
    var startRow: Int
    var startCol: Int

    //Grid coordinates for the final maze square
    var finishRow: Int
    var finishCol: Int

    var squares = mutableListOf<MutableList<MazeSquare>>()

    init {
        var lines = File(filename).readLines()
        var currentMazeChar : Char

        // get dimensions of maze
        var dimensions = lines[0].split(" ")
        numRows = dimensions[0].toInt()
        numCols = dimensions[1].toInt()

        // get position of start square
        var startSquarePosition = lines[1].split(" ")
        startRow = startSquarePosition[0].toInt()
        startCol = startSquarePosition[1].toInt()

        // get position of finish square
        var finishSquarePosition = lines[2].split(" ")
        finishRow = finishSquarePosition[0].toInt()
        finishCol = finishSquarePosition[1].toInt()

        // now fill in the rows
        var mazeData = lines.subList(3, lines.count())
        for (row in 0..<mazeData.count()) {
            var newRow = mutableListOf<MazeSquare>()
            squares.add(newRow)
            for (col in 0..<numCols) {
                currentMazeChar = mazeData[row][col]
                // Add column to row
                when (currentMazeChar) {
                    '7' -> newRow.add(MazeSquare(row, col, true, true))
                    '|' -> newRow.add(MazeSquare(row, col, false, true))
                    '_' -> newRow.add(MazeSquare(row, col, true, false))
                    '*' -> newRow.add(MazeSquare(row, col, false, false))
                    else -> throw RuntimeException("erroneous value ${currentMazeChar}")
                }
            }
        }
    }

    fun printMaze() {

        //We'll print off each row of squares in turn.
        for (row in 0..<numRows) {

            //Print each of the lines of text in the row
            for (lineWithinRow in 0..3) {
                //Need to start with the initial left wall.
                if (lineWithinRow == 0) {
                    print("+")
                } else {
                    print("|")
                }

                for (col in 0..<numCols) {
                    var currentSquare = squares[row][col]
                    if (lineWithinRow == 0) {
                        //We're in the first line of output for this square -
                        //need to print top wall if necessary.
                        if (currentSquare.hasTopWall) {
                            print("-----+")
                        } else {
                            print("     +")
                        }
                    } else if (lineWithinRow == 1 || lineWithinRow == 3) {
                        //These are the interior of the square and are
                        //unaffected by the start/final state.
                        if (currentSquare.hasRightWall) {
                            print("     |")
                        } else {
                            print("      ")
                        }
                    } else {
                        //We must be in the second row of characters. This is
                        //the row where start/finish should be displayed if
                        //relevant

                        //Check if we're in the start or finish state
                        if (row == startRow && col == startCol) {
                            print("  S  ")
                        } else if (row == finishRow && col == finishCol) {
                            print("  F  ")
                        } else if (currentSquare.solutionPiece) {
                            print("  *  ")
                        } else {
                            print("     ")
                        }
                        if (currentSquare.hasRightWall) {
                            print("|")
                        } else {
                            print(" ")
                        }
                    }
                }
                //Now end the line to start the next
                println()
            }
        }

        // print bottom of maze
        print("+")
        for (j in 0..<numCols) {
            print("-----+")
        }
        println()
    }

}


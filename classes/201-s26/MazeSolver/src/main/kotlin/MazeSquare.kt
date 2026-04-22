// Class representing a single square in a maze
data class MazeSquare(
    // Row and column
    var row: Int,
    var col: Int,

    // Wall variables
    val hasTopWall: Boolean,
    val hasRightWall: Boolean,

    // Other variables
    var visited: Boolean = false,
    var solutionPiece: Boolean = false,
)

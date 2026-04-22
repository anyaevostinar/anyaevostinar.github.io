import kotlin.test.Test
import kotlin.test.assertEquals

class MazeTest {
    @Test
    fun test0() {
        println("Test 0")
        var myMaze = SolvableMaze("src/main/resources/maze.txt")
        myMaze.solveMaze()
        myMaze.printMaze()
    }

    @Test
    fun test2() {
        println("Test 2")
        var myMaze = SolvableMaze("src/main/resources/maze2.txt")
        myMaze.solveMaze()
        myMaze.printMaze()
    }

    @Test
    fun test3() {
        println("Test 3")
        var myMaze = SolvableMaze("src/main/resources/maze3.txt")
        myMaze.solveMaze()
        myMaze.printMaze()
    }

    @Test
    fun test4() {
        println("Test 4")
        var myMaze = SolvableMaze("src/main/resources/maze4.txt")
        myMaze.solveMaze()
        myMaze.printMaze()
    }

    @Test
    fun testUnsolvable() {
        println("Test unsolvable")
        var myMaze = SolvableMaze("src/main/resources/unsolvable.txt")
        myMaze.solveMaze()
        myMaze.printMaze()
    }
}

package excelian.solver;

import excelian.maze.Coordinates;
import excelian.maze.Maze;
import java.util.Stack;

/**
 * Author: Achilleas Tzimis on 07/04/2016.
 */
public interface SolveMaze {
    public boolean solveMaze(Coordinates currentLocationPoint);
    public String  getHumanReadablePathOutOfMaze();
    public Stack<Coordinates> getCoordinatePathOutOfMaze();
    public void setMaze(Maze maze);
}

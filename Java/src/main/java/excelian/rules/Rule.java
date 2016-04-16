package excelian.rules;

import excelian.maze.Maze;
/**
 * @author Achilleas Tzimis 7April 2016
 */
public interface Rule {
    boolean isValid(Maze maze);
}

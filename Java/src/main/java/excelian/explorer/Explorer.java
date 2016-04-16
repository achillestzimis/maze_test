package excelian.explorer;

import excelian.maze.Coordinates;
import excelian.maze.InvalidMazeException;
import excelian.maze.Maze;
import excelian.maze.Movement;
import excelian.solver.MazeSolver;
import java.util.Stack;

/**
 *
 * @author Achilleas Tzimis 7April 2016
 */
public class Explorer {
    private Coordinates currentLocation;
    private Maze maze;
    private MazeSolver mazeSolver;

    public String readMaze(Maze validMaze) throws InvalidMazeException {
        maze = validMaze;
        currentLocation = validMaze.getStartCoordinates();
        return validMaze.toString();
    }

    public Coordinates getCurrentLocation() {
        return currentLocation;
    }

    public boolean moveForward() {
        return movepoint(Movement.FORWARD.getMovementAmounts());
    }

    public boolean moveLeft(){
        return movepoint(Movement.LEFT.getMovementAmounts());
    }

    public boolean moveRight(){
        return movepoint(Movement.RIGHT.getMovementAmounts());
    }

    public boolean moveBackward(){
        return movepoint(Movement.BACKWARD.getMovementAmounts());
    }

    private boolean movepoint(Coordinates movementAmount){
        Coordinates newLocation = currentLocation.getNewMazePoint(movementAmount.getX(), movementAmount.getY());
        if(maze.isValidMove(newLocation)){
            currentLocation.translate(movementAmount.getX(),movementAmount.getY());
            return true;
        }
        return false;
    }

    public void setMazeSolver(MazeSolver mazeSolver){
        this.mazeSolver = mazeSolver;
        this.mazeSolver.setMaze(maze);
    }

    public void solveMaze(Coordinates startCoordinates){
        mazeSolver.solveMaze(startCoordinates);
    }

    public String getHumanReadablePathOutOfMaze() {
        return mazeSolver.getHumanReadablePathOutOfMaze();
    }

    public Stack<Coordinates> getCoordinatePathOutOfMaze() {
        return mazeSolver.getCoordinatePathOutOfMaze();
    }
}

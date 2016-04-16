package excelian.solver;

import excelian.maze.*;
import java.util.Stack;
/**
 * Author: Achilleas Tzimis on 07/04/2016.
 */
public class MazeSolver implements SolveMaze {

    private Maze maze;
    private Stack<Coordinates> traverserdPath = new Stack<Coordinates>();
 
    @Override
    public String getHumanReadablePathOutOfMaze() {
        Object[] points = traverserdPath.toArray();
        String s = MazeItem.START.toString()+"\n";
        for(int i = 0; i < points.length -1; i++){
            Movement direction =  Movement.convertToMovement((Coordinates) points[i], (Coordinates)points[i+1]);
            s+= direction.toString() + "\n";
        }
        return s + MazeItem.FINISH.toString();
    }

    @Override
    public Stack<Coordinates> getCoordinatePathOutOfMaze() {
        return traverserdPath;
    }

    @Override
    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    @Override
    public boolean solveMaze(Coordinates currentLocationCoordinates){
        if(maze.isExit(currentLocationCoordinates)){
            return true;
        }
        if(traverserdPath.search(currentLocationCoordinates) == -1){
            traverserdPath.push(currentLocationCoordinates);
        }else{
            return false;
        }
        Stack<Coordinates> possibleValidMovesCoordinates =   new Stack<Coordinates>();
        maze.getAllValidMovesCoordinates(currentLocationCoordinates, possibleValidMovesCoordinates);
        while (!possibleValidMovesCoordinates.empty()){
            Coordinates newCoordinates = possibleValidMovesCoordinates.pop();
            if( solveMaze(newCoordinates)){
                return true;
            }
        }
        traverserdPath.pop();
        return false;
    }
}

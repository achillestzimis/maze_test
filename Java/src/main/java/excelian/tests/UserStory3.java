package excelian.tests;

import excelian.explorer.Explorer;
import excelian.solver.MazeSolver;
import org.junit.Test;
import excelian.maze.InvalidMazeException;
import java.util.Stack;
import excelian.maze.*;
import static org.junit.Assert.assertEquals;


/**
 *
 * @author Achilleas Tzimis
 */
public class UserStory3 {
    
    public static void main(String args[]){
        UserStory3 b = new UserStory3();
        
        try{
            b.solveComplexMazeA();
            }catch(Exception e){
            System.out.println("Invalid maze");
        }
    }
     
    /*
     * This method should solve the maze below with and print the route taken.
     */
    @Test
    public void solveComplexMazeA() throws InvalidMazeException{
        Explorer explorer = new Explorer();
        Maze maze = new Maze(
                            "XXXXXXXXXXXXXXX\n" +
                            "X             X\n" +
                            "X XXXXXXXXXXX X\n" +
                            "X XS        X X\n" +
                            "X XXXXXXXXX X X\n" +
                            "X XXXXXXXXX X X\n" +
                            "X XXXX      X X\n" +
                            "X XXXX XXXX X X\n" +
                            "X XXXX XXXX X X\n" +
                            "X X    XXXXXX X\n" +
                            "X X XXXXXXXXX X\n" +
                            "X X XXXXXXXXX X\n" +
                            "X X         X X\n" +
                            "X XXXXXXXXX   X\n" +
                            "XFXXXXXXXXXXXXX\n");
        explorer.readMaze(maze);
        explorer.setMazeSolver(new MazeSolver());
        explorer.solveMaze(maze.getStartCoordinates());
        String returnedPath =  explorer.getHumanReadablePathOutOfMaze();
        String expectedMovements = "START\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "BACKWARD\n" +
                "RIGHT\n" +
                "RIGHT\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "FORWARD\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "LEFT\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "BACKWARD\n" +
                "FINISH";     
         assertEquals(expectedMovements,returnedPath.toString());
         System.out.println("Route taken in this maze is "+returnedPath.toString());
    }
}

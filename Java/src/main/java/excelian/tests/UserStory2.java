package excelian.tests;

import excelian.explorer.Explorer;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import excelian.maze.InvalidMazeException;
import excelian.solver.MazeSolver;
import java.util.Stack;
import excelian.maze.*;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Achilleas Tzimis
 */
public class UserStory2 {
    
    public static void main(String args[]){
        UserStory2 story = new UserStory2();
        try{
            story.getExistingStartCoordinates();
            story.getAllValidMoves();
            story.move1spaceForward();
            story.move1spaceLeft();
            story.move1spaceRight();
            }catch(Exception e){
            System.out.println("Invalid maze");
        }
    }
    /*
     * This start coordinates of this maze should be 2,5.
     */
    @Test
    public void getExistingStartCoordinates() throws InvalidMazeException{
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
        Coordinates startCoordinates = maze.getStartCoordinates();
        System.out.println("The start coordinates of this maze are "+startCoordinates);
    }
    
    /*
     * This method returns all movement options and whats in front of their given location.
     */
    @Test
    public void getAllValidMoves() throws  InvalidMazeException{
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
        Stack<String> returnedValidMovedments  = new Stack<String>();
        maze.getAllValidMovements(maze.getStartCoordinates(), returnedValidMovedments);
        System.out.println("valid moves are "+returnedValidMovedments.toString());
    }
    
    /*
     *   This method returns the coordinates of one move forward.
     */
    @Test
    public void move1spaceForward() throws InvalidMazeException {
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
        Coordinates currentLocation1 = explorer.getCurrentLocation();
        System.out.println("The forward location1 is "+currentLocation1);
        explorer.moveForward();
        Coordinates currentLocation = explorer.getCurrentLocation();
        System.out.println("The forward location is "+currentLocation);
        Coordinates expectedLocation = new Coordinates(3,3);
        assertEquals(expectedLocation,currentLocation);
        System.out.println("The forward location is "+currentLocation);
    }
    
    /*
     *   This method returns the coordinates of one move left.
     */
    @Test
    public void move1spaceLeft() throws InvalidMazeException {
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
        explorer.moveLeft();
        Coordinates currentLocation = explorer.getCurrentLocation();
        System.out.println("The currentLocation on move1spaceLeft is "+currentLocation);
        
        Coordinates expectedLocation = new Coordinates(3,3);
        assertEquals(expectedLocation,currentLocation);
    }
    
    /*
     *   This method returns the coordinates of one move right.
     */
    @Test
    public void move1spaceRight() throws InvalidMazeException {
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
        explorer.moveRight();
        Coordinates currentLocation = explorer.getCurrentLocation();
        Coordinates expectedLocation = new Coordinates(3,4);
        assertEquals(expectedLocation,currentLocation);
        System.out.println("The currentLocation is "+currentLocation);
    }
}

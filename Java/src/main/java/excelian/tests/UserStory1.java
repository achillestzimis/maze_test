
package excelian.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import excelian.maze.Maze;


/**
 *
 * @author Achilleas Tzimis
 */
public class UserStory1 {
     
    public static void main(String args[]){
     UserStory1 j  = new UserStory1();
     j.countNumberOfWalls();
     j.countNumberOfEmptySpaces();
     j.checkLoadValidMaze();
     j.checkItemInMaze();
    }
    
    /*
     * This test should count the number of walls.
     */
    @Test
    public void countNumberOfWalls() {
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
        int expectedNumOfWalls = 150;
        assertEquals(expectedNumOfWalls,maze.getNumOfWalls() );
        System.out.println("Number of walls are "+maze.getNumOfWalls());
    }
    
    /*
     * This test should count the number of empty space.
     */
    @Test
    public void countNumberOfEmptySpaces(){
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
        int expectedNumOfEmptySpaces = 74;
        assertEquals(expectedNumOfEmptySpaces,maze.getNumEmtpySpaces());
        System.out.println("Number of empty space is "+maze.getNumEmtpySpaces());
    }   
        
    /*
     * This test should tell us if the maze is valid.
     */
    @Test
    public void checkLoadValidMaze(){
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
        assertTrue("Maze validity check returned False on Valid Maze", maze.isValid());
    }   
        
    /*
     * This test should return 'S'
     */
    @Test
    public void checkItemInMaze(){
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
        System.out.println("At coordinate(3,3) there is "+maze.getItemAtCoordinates(3,3));
     }
}

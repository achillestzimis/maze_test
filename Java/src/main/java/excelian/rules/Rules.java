package excelian.rules;

import excelian.maze.Maze;
import excelian.maze.MazeItem;
import java.util.regex.Pattern;

/**
 * @author Achilleas Tzimis 7April 2016
 */
public class Rules {

    public static void bindRules(Maze maze){
        maze.addRule(new MazeContainsCorrectChars());
        maze.addRule(new MazeContainsSpaces());
        maze.addRule(new MazeIsCorrectSize());
        maze.addRule(new MazeContainsOnlyOneOfCharacter());
    }

    public static class MazeIsCorrectSize implements Rule{
        private int MINIMUM_MAZE_SIZE = 9;
        public boolean isValid(Maze maze) {
            return (maze.toString().length() >= MINIMUM_MAZE_SIZE);
        }
    }

    public static boolean validateMaze(Maze maze){
        int isvalid = 0;
        for(Rule rule: maze.getRules()){
            boolean mazeIsValid = rule.isValid(maze);
            isvalid +=  (mazeIsValid?0:1);
        }
        return isvalid == 0;
    }

    public static class MazeContainsCorrectChars implements Rule{
        public boolean isValid(Maze maze){
            String allValidSymbols = "";
            for(MazeItem m: MazeItem.values()){
                if(m.getSymbol() == " "){
                    allValidSymbols+="\\s";
                 }else {
                    allValidSymbols += m.getSymbol();
                }
            }
            Pattern badChars = Pattern.compile("[^"+allValidSymbols+"]+");
            if (badChars.matcher(maze.toString()).find()) {
                return false;
            }
            return true;
        }
    }

    public static class MazeContainsOnlyOneOfCharacter implements Rule {

        public boolean isValid(Maze maze) {
            return checkContents(maze, MazeItem.START)&&checkContents(maze, MazeItem.FINISH);
        }

        private boolean checkContents(Maze maze, MazeItem item) {
            int numOccurences = splitMazeByCharacter( maze.toString(),item.getSymbol()).length - 1;
            return numOccurences == 1;
        }

        private static String[] splitMazeByCharacter(String mazeAsString,String character){
            String[] splitmaze = mazeAsString.split(character);
            return splitmaze;
        }
    }

    public static class MazeContainsSpaces implements Rule {
        public boolean isValid(Maze maze){
        Pattern finishChar = Pattern.compile("\\s");
         return finishChar.matcher(maze.toString()).find();
        }
    }
}

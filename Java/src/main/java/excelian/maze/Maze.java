package excelian.maze;

import excelian.rules.Rule;
import excelian.rules.Rules;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Achilleas Tzimis 7April 2016
 */
public class Maze {

    private String mazeAsString;
    private String[][] mazeAsGrid;
    private int numOfWalls;
    private int numEmtpySpaces = -1;
    private Coordinates startCoordinates = new Coordinates();
    private List<Rule> rules = new ArrayList<Rule>();


    public  Maze(String mazeAsString) {
        setMaze(mazeAsString);
        generateGrid();
    }

    private void generateGrid(){
        String [] rows = mazeAsString.split("\n");
        mazeAsGrid = new String[rows.length][];
        int col = 0;
        for (String row : rows) {
            int indexOfStart = row.indexOf(MazeItem.START.getSymbol());
            if(indexOfStart!= -1 ){
                startCoordinates.setLocation(col,indexOfStart);
            }
            mazeAsGrid[col++] = row.split("");
        }
    }

    public boolean isValid() {
        Rules.bindRules(this);
        return Rules.validateMaze(this);
    }

    private String[] splitMazeByCharacter(MazeItem item){
        String symbol = item.getSymbol();
        if(item == MazeItem.EMPTYSPACE){
            symbol = " ";
        }
        String[] splitMaze = mazeAsString.split(symbol);
        return splitMaze;
    }

    public int getNumOfWalls() {
        String[] splitMaze = splitMazeByCharacter(MazeItem.WALL);
        numOfWalls = splitMaze.length;
        return numOfWalls;
    }

    public int getNumEmtpySpaces() {
        String[] splitMaze = splitMazeByCharacter(MazeItem.EMPTYSPACE);
        numEmtpySpaces = splitMaze.length -1;
        return numEmtpySpaces;
    }

    public String getItemAtCoordinates(int rownum, int colnum) {
        try {
            return mazeAsGrid[rownum][colnum];
        }catch(ArrayIndexOutOfBoundsException ae){
            return MazeItem.OUTOFBOUNDS.getSymbol();
        }
    }

    public void setMaze(String mazeAsString) {
        this.mazeAsString = mazeAsString;
    }

    public Coordinates getStartCoordinates() throws InvalidMazeException {
        if(!isValid()){
            throw new InvalidMazeException("Unable to get start coordinates for invalid maze");
        }
        return startCoordinates;
    }

    public String getItemAtCoordinates(Coordinates newLocation) {
        return getItemAtCoordinates(newLocation.getX(),newLocation.getY());

    }

    public boolean isExit(Coordinates point){

       String item = getItemAtCoordinates(point);
       MazeItem m = MazeItem.getMazeItemBySymbol(item);
        if(m == MazeItem.FINISH) {
            return true;
        }
        return false;
    }

    public Stack<Coordinates> getAllValidMovesCoordinates(Coordinates currentCoordinates, Stack <Coordinates> possibleValidMoves) {
        possibleValidMoves.clear();
        for(Movement movement: Movement.values()){
            if(isNextMoveValid(movement,(currentCoordinates))){
                possibleValidMoves.add(movement.move(currentCoordinates));
            }
        }
        return possibleValidMoves;
    }

    private boolean isNextMoveValid( Movement directionalMovement, Coordinates currentCoordinates) {
        if(isValidMove(directionalMovement.move(currentCoordinates))) {
            return true;
        }return false;
    }

    public boolean isValidMove(Coordinates newLocation) {
        String path = getItemAtCoordinates(newLocation);
         if(path.matches(constructRegexMatch(MazeItem.EMPTYSPACE)) ||path.matches(constructRegexMatch(MazeItem.FINISH))){
            return true;
        }
        return false;
    }

    private String constructRegexMatch(MazeItem mazeItem){
        return "^"+mazeItem.getSymbol()+"*$";
    }

    public Stack <String> getAllValidMovements(Coordinates currentCoordinates, Stack<String> possibleValidMoves){
        possibleValidMoves.clear();
        for(Movement movement: Movement.values()){
            if(isNextMoveValid(movement,(currentCoordinates))){
                possibleValidMoves.add(movement.toString());
            }
        }
        return possibleValidMoves;
    }

    @Override
    public String toString(){
        return mazeAsString;
    }

    public void addRule(Rule rule) {
        rules.add(rule);
    }

    public List<Rule> getRules() {
        return rules;
    }
}

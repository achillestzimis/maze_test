package excelian.maze;

/**
 *
 * @author Achilleas Tzimis 7April 2016
 */
public enum Movement {
    LEFT(0,-1),
    RIGHT(0, 1),
    BACKWARD(1, 0),
    FORWARD(-1, 0),
    INVALIDMOVEMENT(0,0);

    private final int firstnum;
    private final int secondnum;

    Movement(int firstnum, int secondnum){
        this.firstnum = firstnum;
        this.secondnum = secondnum;
    }

    public Coordinates getMovementAmounts(){
        return new Coordinates(firstnum,secondnum);
    };

    public Coordinates move(Coordinates currentCoordinates) {
        Coordinates newpoint =  currentCoordinates.getLocation();
        newpoint.translate(firstnum, secondnum);
        return newpoint;
    }

    public static Movement convertToMovement(Coordinates orginalCoordinates, Coordinates newCoordinates){
        Coordinates distanceBtwMazePointsCoordinates = newCoordinates.distanceToCoordinate(orginalCoordinates);

        if(distanceBtwMazePointsCoordinates.getX() < 0){
            return Movement.FORWARD;
        }else if (distanceBtwMazePointsCoordinates.getX() > 0){
            return Movement.BACKWARD;
        }else if(distanceBtwMazePointsCoordinates.getY() < 0){
            return Movement.LEFT;
        }else if (distanceBtwMazePointsCoordinates.getY() > 0){
            return Movement.RIGHT;
        }
        return Movement.INVALIDMOVEMENT;
    }


}




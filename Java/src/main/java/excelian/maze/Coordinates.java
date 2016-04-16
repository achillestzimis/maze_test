package excelian.maze;

/**
 * @author Achilleas Tzimis 7April 2016
 */
public class Coordinates  {
    private int x = 0;
    private int y = 0;

public Coordinates(int x, int y){
    this.x = x;
    this.y = y;
}

    public Coordinates(){

    }

    public Coordinates getLocation(){
        return new Coordinates(this.x, this.y);
    }

    public Coordinates getNewMazePoint(int xmoves, int ymoves){
        Coordinates newLocation = new Coordinates(this.x, this.y);
        newLocation.translate(xmoves,ymoves);
        return newLocation;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        return this.x+","+this.y;
    }

    public Coordinates distanceToCoordinate( Coordinates newCoordinates){
        return new Coordinates(distanceBtwCoord(newCoordinates.x, this.x),distanceBtwCoord(newCoordinates.y, this.y));
    }

    private int distanceBtwCoord(int startCoord, int secondCoord){
        return  secondCoord - startCoord;
    }

    public void translate(int distancex, int distancey) {
        this.x += distancex;
        this.y += distancey;
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Coordinates) {
            Coordinates pt = (Coordinates)obj;
            return (x == pt.x) && (y == pt.y);
        }else {
            return false;
        }
    }
}

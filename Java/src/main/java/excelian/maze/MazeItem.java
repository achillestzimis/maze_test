package excelian.maze;

import java.util.Map;

/*
 * @author Achilleas Tzimis 7April 2016
 */
public enum MazeItem{
    FINISH("F"),
    START("S"),
    WALL("X"),
    EMPTYSPACE(" "),
    OUTOFBOUNDS("O");

   private  final String mazeSymbol;
   
    MazeItem (String mazeSymbol){
        this.mazeSymbol = mazeSymbol;
    }

    public String getSymbol(){
        return mazeSymbol;
    }

   public static MazeItem getMazeItemBySymbol(String symbol){
       for (MazeItem item: MazeItem.values()){
           if(item.getSymbol().compareTo(symbol)==0){
               return item;
           }
       }
       return null;
   }
}

/**
 * This is a Wall class representing a wall in a dungeon game.
 * It provides methods to get wall attributes and destroy walls.
 * @author Choa, Jon Regan and Castillo, Franz Tristan
 * @version 3.0
 * @since 2025-10-16
 */
public class Wall {
    /**
     * Attributes of Class Wall
     * @param isBreakable Indicates if the wall is breakable
     */
    private boolean isBreakable;

    /**
     * Constructor for Class Wall
     * @param isBreakable Indicates if the wall is breakable
     */
    public Wall(boolean isBreakable){
        this.isBreakable = isBreakable;
    }
    /**
     * Getters for Wall attributes
     * @return isBreakable depending on whether the wall can be broken or not
     */
    public boolean getIsBreakable() {
        return isBreakable;
    }
    
    /**
     * Method to destroy the wall if it is breakable
     */
    public void destroyWall(){
        if (isBreakable){
            System.out.println("Wall destroyed");
        } 
        else{
            System.out.println("Wall cannot be destroyed");
        }
    }
}

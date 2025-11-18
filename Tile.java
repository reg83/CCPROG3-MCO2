/**
 * This is a Tile class representing a tile in a dungeon game.
 * It provides methods to get and set tile attributes.
 * @author Choa, Jon Regan and Castillo, Franz Tristan
 * @version 3.0
 * @since 2025-10-16
 */
public class Tile {
    /**
     * Enum for Tile types
     * PASSABLE - Tile that can be traversed regularly
     * IMPASSABLE - Tile that cannot be traversed (such as walls, regardless of breakability. IMPASSABLE converts to PASSABLE
     * when a breakable wall is destroyed)
     */
    public enum Type { PASSABLE, IMPASSABLE }

    /**
     * Attribute of Class Tile
     * @param type Type of the Tile (PASSABLE or IMPASSABLE)
     */
    private Type type;

    /**
     * Constructor for Class Tile
     * Separate constructors were created for easier instantiation, using enum values
     * @param type Type of the Tile (PASSABLE or IMPASSABLE)
     */
    public Tile(Type type){
        this.type = type;
    }

    /**
     * Constructor for Class Tile
     * Separated constructors were created for easier instantiation, using boolean values
     * @param isPassable boolean value indicating if the tile is PASSABLE or IMPASSABLE
     */
    public Tile(boolean isPassable){
        if (isPassable){
            this.type = Type.PASSABLE;
        } 
        else{
            this.type = Type.IMPASSABLE;
        }
    }
    /**
     * Method to check if the tile is passable
     * @return true if the tile is PASSABLE
     */
    public boolean isPassable(){
        return this.type == Type.PASSABLE;
    }

    /** 
     * Getter for Tile Type
     * @return type of the tile
     */
    public Type getType(){
        return this.type;
    }

    /** 
     * Setter for Tile Type
     * @param type type of the tile to be set
     */
    public void setType(Type type){
        this.type = type;
    }

    /**
     * Setter for Tile Passability
     * @param isPassable boolean value indicating if the tile is PASSABLE or IMPASSABLE
     */
    public void setPassable(boolean isPassable) {
        if (isPassable){
            this.type = Type.PASSABLE;
        } 
        else{
            this.type = Type.IMPASSABLE;
        }
    }
}

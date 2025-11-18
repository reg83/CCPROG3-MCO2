/**
 * This is a Dungeon class representing a dungeon in a dungeon game.
 * It provides methods to get dungeon attributes, print the dungeon layout,
 * update tiles, and place bombs.
 * @author Choa, Jon Regan and Castillo, Franz Tristan
 * @version 3.0
 * @since 2025-10-16
 */
public class Dungeon {
    /**
     * Attributes of Class Dungeon
     * @param name Name of the Dungeon
     * @param width Width of the Dungeon
     * @param height Height of the Dungeon
     * @param spawnPointX X-coordinate of the Hero's spawn point
     * @param spawnPointY Y-coordinate of the Hero's spawn point
     * @param dungeonLevel Level of the Dungeon
     * @param isCleared Indicates if the Dungeon is cleared
     * @param tiles 2D array of Tiles in the Dungeon
     * @param walls 2D array of Walls in the Dungeon
     */
    private String name;
    private int width;
    private int height;
    private int spawnPointX;
    private int spawnPointY;
    private int dungeonLevel;
    private boolean isCleared;
    public Tile[][] tiles;
    public Wall[][] walls;
    public Zombie[][] zombies;

    /**
     * Constructor for Class Dungeon
     * @param name Name of the Dungeon
     * @param w Width of the Dungeon
     * @param h Height of the Dungeon
     * @param spawnPointX X-coordinate of the Hero's spawn point
     * @param spawnPointY Y-coordinate of the Hero's spawn point
     * @param dungeonLevel Level of the Dungeon
     * @param isCleared Indicates if the Dungeon is cleared
     */
    public Dungeon(String name, int w, int h, int spawnPointX, int spawnPointY, int dungeonLevel, boolean isCleared){
        this.name = name;
        this.width = w;
        this.height = h;
        this.spawnPointX = spawnPointX;
        this.spawnPointY = spawnPointY;
        this.dungeonLevel = dungeonLevel;
        this.isCleared = isCleared;
        this.tiles = new Tile[height][width];
        this.walls = new Wall[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.tiles[i][j] = new Tile(Tile.Type.PASSABLE);
                this.walls[i][j] = new Wall(false);
            }
        }
        this.zombies = new Zombie[height][width];
    }
    /**
     * Getters for Dungeon attributes
     * @return name of the dungeon
     */
    public String getName(){
        return name;
    }
    /**
     * Getters for Dungeon attributes
     * @return width of the dungeon
     */
    public int getWidth(){
        return width;
    }
    /**
     * Getters for Dungeon attributes
     * @return height of the dungeon
     */
    public int getHeight(){
        return height;
    }
    /**
     * Getters for Dungeon attributes
     * @return spawnPointX of the dungeon
     */
    public int getSpawnPointX(){
        return spawnPointX;
    }
    /**
     * Getters for Dungeon attributes
     * @return spawnPointY of the dungeon
     */
    public int getSpawnPointY(){
        return spawnPointY;
    }

    public int getDungeonLevel(){
        return dungeonLevel;
    }

    public boolean getIsCleared(){
        return isCleared;
    }

    /**
     * This method prints the dungeon layout, showing the hero's position,
     * passable tiles, breakable walls, and unbreakable walls.
     * @param h The hero whose position will be displayed in the dungeon
     */
    public void printDungeon(Hero h) {

        System.out.println("Legend:");
        System.out.println("H: Hero");
        System.out.println(".: Passable Tile");
        System.out.println("+: Breakable Wall");
        System.out.println("#: Unbreakable Wall");

        for (int i = 0; i < this.getHeight(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {

                if (h.getX() == j && h.getY() == i) {
                    System.out.print("H");
                } else if (this.tiles[i][j].isPassable()) {
                    System.out.print(".");
                } else if (this.walls[i][j].getIsBreakable()) {
                    System.out.print("+");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
    /**
     * Method to update a tile's type in the dungeon
     * @param x x-coordinate of the tile to be updated
     * @param y y-coordinate of the tile to be updated
     * @param tileType The new type of tile that is updated
     */
    public void updateTile(int x, int y, Tile.Type tileType){
        if (x >= 0 && x < width && y >= 0 && y < height) {
            this.tiles[y][x].setType(tileType);
        }
    }
    /**
     * Method to place the bomb in the dungeon
     * It logs the position and the explosion radius of the bomb object
     * @param x x-coordinate of the bomb to be placed
     * @param y y-coordinate of the bomb to be placed
     * @param b the bomb object to be placed
     */
    public void placeBomb(int x, int y, Bomb b){
        System.out.println("Placing bomb at (" + b.getX() + ", " + b.getY() + ") with explosion radius " + b.getExplosionRadius() + ".");
    }

    public void spawnZombie(Zombie z){
        zombies[z.getY()][z.getX()] = z;
    }

    public void removeZombie(Zombie z){
        zombies[z.getY()][z.getX()] = null;
    }

    public void lvlUp(){
        this.dungeonLevel++;
    }
}

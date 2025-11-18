/**
 * This is a Bomb class representing a bomb in a dungeon game.
 * It provides methods to get bomb attributes , detonate, and explode the bomb.
 * @author Choa, Jon Regan and Castillo, Franz Tristan
 * @version 3.0
 * @since 2025-10-16
 */
public class Bomb {
    /**
     * Attributes of Class Bomb
     * @param baseAtk Base Attack Power of the Bomb
     * @param explosionRadius Explosion Radius of the Bomb
     * @param x X-coordinate of the Bomb's position
     * @param y Y-coordinate of the Bomb's position
     */
    private float baseAtk;
    private int explosionRadius;
    private int x;
    private int y;
    /**
     * Constructor for Class Bomb
     * @param baseAtk Base Attack Power of the Bomb
     * @param explosionRadius Explosion Radius of the Bomb
     * @param x X-coordinate of the Bomb's position
     * @param y Y-coordinate of the Bomb's position
     */
    public Bomb(float baseAtk, int explosionRadius, int x, int y){
        this.baseAtk = baseAtk;
        this.explosionRadius = explosionRadius;
        this.x = x;
        this.y = y;
    }
    /**
     * Getters for Bomb attributes
     * @return baseAtk of the bomb
     */
    public float getBaseAtk(){
        return baseAtk;
    }
    /**
     * Getters for Bomb attributes
     * @return explosionRadius of the bomb
     */
    public int getExplosionRadius(){
        return explosionRadius;
    }
    /**
     * Getters for Bomb attributes
     * @return x coordinate of the bomb
     */
    public int getX(){
        return x;
    }
    /**
     * Getters for Bomb attributes
     * @return y coordinate of the bomb
     */
    public int getY(){
        return y;
    }
   /**
    * This method detonates the bomb in the dungeon, destroying breakable walls within the explosion radius.
    * Each direction (up, down, left, right) is checked for walls to destroy.
    * @param d The dungeon where the bomb is detonated
    * @param walls The 2D array of walls in the dungeon
    */
    public void detonate(Dungeon d, Wall[][] walls){
        System.out.println("Bomb detonated in dungeon " + d.getName() + " at position (" + x + ", " + y + ") with explosion radius " + explosionRadius + " and base attack " + baseAtk + ".");

        for (int i = 1; i <= explosionRadius; i++){
            int rightX = x + i;
            int leftX = x - i;
            int downY = y + i;
            int upY = y - i;
        
            // Right
            if (rightX >= 0 && rightX < d.getWidth() && y >= 0 && y < d.getHeight()){
                if (walls != null && walls[y][rightX] != null){
                    Wall w = walls[y][rightX];
                    if (w.getIsBreakable()){
                        w.destroyWall();
                        walls[y][rightX] = null;
                        d.tiles[y][rightX].setPassable(true);
                        System.out.println("Breakable wall at (" + rightX + "," + y + ") destroyed by bomb.");
                    }
                }
            }

            // Left
            if (leftX >= 0 && leftX < d.getWidth() && y >= 0 && y < d.getHeight()){
                if (walls != null && walls[y][leftX] != null){
                    Wall w = walls[y][leftX];
                    if (w.getIsBreakable()){
                        w.destroyWall();
                        walls[y][leftX] = null;
                        d.tiles[y][leftX].setPassable(true);
                        System.out.println("Breakable wall at (" + leftX + "," + y + ") destroyed by bomb.");
                    } 
                }
            }

            // Down
            if (x >= 0 && x < d.getWidth() && downY >= 0 && downY < d.getHeight()){
                if (walls != null && walls[downY][x] != null){
                    Wall w = walls[downY][x];
                    if (w.getIsBreakable()){
                        w.destroyWall();
                        walls[downY][x] = null;
                        d.tiles[downY][x].setPassable(true);
                        System.out.println("Breakable wall at (" + x + "," + downY + ") destroyed by bomb.");
                    } 
                }
            }

            // Up
            if (x >= 0 && x < d.getWidth() && upY >= 0 && upY < d.getHeight()){
                if (walls != null && walls[upY][x] != null){
                    Wall w = walls[upY][x];
                    if (w.getIsBreakable()){
                        w.destroyWall();
                        walls[upY][x] = null;
                        d.tiles[upY][x].setPassable(true);
                        System.out.println("Breakable wall at (" + x + "," + upY + ") destroyed by bomb.");
                    } 
                }
            }

            // Damage zombies in range
            

        }
        
    }
    /**
     * This method logs out the tiles affected by the explosion within the explosion radius.
     * @param d The dungeon where the bomb explodes
     * @param x The X-coordinate of the bomb's position
     * @param y The Y-coordinate of the bomb's position
     */
    public void explode(Dungeon d, int x, int y){
        System.out.println("Bomb exploded in dungeon " + d.getName() + " causing damage within radius " + explosionRadius + " at position (" + x + ", " + y + ").");
        for (int i = 1; i <= explosionRadius; i++) {
            if (x + i < d.getWidth()) { // Right
                System.out.println("Bomb hits tile at (" + (x + i) + ", " + y + ")");
            }
            if (x - i >= 0) { // Left
                System.out.println("Bomb hits tile at (" + (x - i) + ", " + y + ")");
            }
            if (y + i < d.getHeight()) { // Down
                System.out.println("Bomb hits tile at (" + x + ", " + (y + i) + ")");
            }
            if (y - i >= 0) { // Up
                System.out.println("Bomb hits tile at (" + x + ", " + (y - i) + ")");
            }
        }
    }

    public void setBombDamage(int dungeonLevel) {
        switch(dungeonLevel){
            case 1: baseAtk = 3;
            break;
            case 2: baseAtk = 5;
            break;
            case 3: baseAtk = 7;
            break;
            default:
                baseAtk = 3;
        }
}
}
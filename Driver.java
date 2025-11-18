import java.util.Scanner;
/**
 * This is the Driver class to run the dungeon game.
 * It handles user's input for game controls and manages the game.
 * @author Choa, Jon Regan and Castillo, Franz Tristan
 * @version 3.0
 * @since 2025-10-16
 */
public class Driver {

    /** 
     * Constructor for Driver class. This is only to remove the warning when using javadoc command
     * */
    public Driver() {
    }
    /**
     * Driver main to run program
     * @param args CLI arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // User input
        Dungeon dungeon = new Dungeon("Demo Dungeon", 11, 9, 1, 1, 0, false);
        Hero hero = new Hero("Hero", 100f, 10f, dungeon.getSpawnPointX(), dungeon.getSpawnPointY(), 0, 0);
        
        // Loop to set up the dungeon's layout (walls and tiles)
        for (int i = 0; i < dungeon.getHeight(); i++) {
            for (int j = 0; j < dungeon.getWidth(); j++) {
                if (i == 0 || i == dungeon.getHeight() - 1 || j == 0 || j == dungeon.getWidth() - 1) {
                    dungeon.updateTile(j, i, Tile.Type.IMPASSABLE);
                    dungeon.walls[i][j] = new Wall(false);
                } else {
                    dungeon.updateTile(j, i, Tile.Type.PASSABLE);
                }
            }
        }
        // Set some breakable walls in the dungeon (as well as testing the bomb)
        int[][] breakableWalls = {{3,2},{3,3},{3,4},{3,5},{3,6},{7,2},{7,3},{7,4},{7,5},{7,6}};
        for (int i = 0; i < breakableWalls.length; i++){ 
            int bx = breakableWalls[i][0]; 
            int by = breakableWalls[i][1];

            // Ensure the walls impacted are within the dungeon's boundaries
            if (bx >= 0 && bx < dungeon.getWidth() && by >= 0 && by < dungeon.getHeight()) {
                dungeon.updateTile(bx, by, Tile.Type.IMPASSABLE);
                dungeon.walls[by][bx] = new Wall(true);
            }
        }
        
        // Make sure the game is running!
        boolean running = true;
        while (running) {

            System.out.println("Controls: W: Up, A: Left, S: Down, D: Right, B: Drop Bomb, Q: Quit");

            dungeon.printDungeon(hero);

            System.out.print("\nEnter command (W/A/S/D to move, B drop bomb, Q quit): ");
            char cmd = Character.toUpperCase(sc.next().charAt(0)); // User command non-case sensitive

            // For logging positions
            System.out.println("Previous Hero position: (" + hero.getX() + ", " + hero.getY() + ")");
            int newX = hero.getX();
            int newY = hero.getY();

            switch (cmd) {
                case 'W': // up
                    newY--;
                    break;
                case 'S': // down
                    newY++;
                    break;
                case 'A': // left
                    newX--;
                    break;
                case 'D': // right
                    newX++;
                    break;
                case 'B': // drop bomb
                    Bomb bomb = new Bomb(15f, 2, hero.getX(), hero.getY());
                    hero.dropBomb(dungeon, bomb);
                    dungeon.placeBomb(hero.getX(), hero.getY(), bomb);
                    bomb.detonate(dungeon, dungeon.walls);
                    bomb.explode(dungeon, hero.getX(), hero.getY());
                    break;
                case 'Q': // quit
                    running = false;
                    break;
                default:
                    System.out.println("Invalid command!");
                    break;
            }

            // Move the hero if the moved position is within boundaries and the tile is passable
            if (newX >= 0 && newX < dungeon.getWidth() && 
                newY >= 0 && newY < dungeon.getHeight() &&
                dungeon.tiles[newY][newX].isPassable()) {
                
                if (newY < hero.getY()) {
                    hero.move(0); // up
                } else if (newY > hero.getY()) {
                    hero.move(1); // down
                } else if (newX < hero.getX()) {
                    hero.move(2); // left
                } else if (newX > hero.getX()) {
                    hero.move(3); // right
                }
                
                // Log the new position
                System.out.println("Hero moved to (" + hero.getX() + ", " + hero.getY() + ").");
            } else {
                System.out.println("Cannot move there - blocked!");
            }
        }
    
        sc.close();
        System.out.println("Game ended."); // When the player presses Q this appears
    }

}
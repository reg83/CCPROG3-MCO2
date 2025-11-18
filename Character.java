/**
 * This is a parent Character class representing a character in a dungeon game.
 * It provides methods to get character attributes, manage health, and move the character.
 * @author Choa, Jon Regan and Castillo, Franz Tristan
 * @version 3.0
 * @since 2025-10-16
 */

class Character {
    /**
     * Attributes of the Character class
     * @param name Name of the Character
     * @param hp Health Points of the Character
     * @param maxHp Maximum Health Points of the Character
     * @param atk Attack Power of the Character
     * @param lvl Level of the Character
     * @param x X-coordinate of the Character's position
     * @param y Y-coordinate of the Character's position
     */
    protected String name;
    protected float hp;
    protected float maxHp;
    protected float atk;
    protected int lvl;
    protected int x;
    protected int y;
    /**
     * Constructor for Class Character
     * @param name Name of the Character
     * @param hp Health Points of the Character
     * @param maxHp Maximum Health Points of the Character
     * @param atk Attack Power of the Character
     * @param lvl Level of the Character
     * @param x X-coordinate of the Character's position
     * @param y Y-coordinate of the Character's position
     */
    public Character(String name, float hp, float maxHp, float atk, int lvl, int x, int y){
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.atk = atk;
        this.lvl = lvl;
        this.x = x;
        this.y = y;
    }
    /**
     * Getters for Hero attributes
     * @return name of the hero
     */
    public String getName(){
        return name;
    }
    /**
     * Getters for Hero attributes
     * @return hp of the hero
     */
    public float getHp(){
        return hp;
    }
    /**
     * Getters for Hero attributes
     * @return maxHp of the hero
     */
    public float getMaxHp(){
        return maxHp;
    }
    /**
     * Getters for Hero attributes
     * @return atk of the hero
     */
    public float getAtk(){
        return atk;
    }
    /**
     * Getters for Hero attributes
     * @return lvl of the hero
     */
    public int getLvl(){
        return lvl;
    }
    /**
     * Getters for Hero attributes
     * @return x coordinate of the hero
     */
    public int getX(){
        return x;
    }
    /**
     * Getters for Hero attributes
     * @return y coordinate of the hero
     */
    public int getY(){
        return y;
    }
    /**
     * Method for the Hero to take damage
     * @param dmg amount of damage to be taken
     */
    public void takeDamage(float dmg){
        hp -= dmg;
        if (hp < 0) {
            hp = 0;
        }
    }
    /**
     * Method for the Hero to heal
     * @param healAmount amount of health to be restored
     */
    public void heal(float healAmount){
        hp += healAmount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }

    /**
     * Method to check if the Hero is alive
     * @return true if the Hero's hp is greater than 0
     * @return false if the Hero's hp is 0 or less
     */
    public boolean isAlive(){
        if (hp > 0){
            return true;
        } 
        else{
            return false;
        }
    }
    /**
     * Method to level up the Hero
     */
    public void lvlUp(int dungeonLevel){
        this.lvl = dungeonLevel;
    }

    /**
     * Method to move the Hero in the dungeon through passable tiles only.
     * @param dir Direction to move the Hero (0: up, 1: down, 2: left, 3: right)
     */
    public void move(int dir){
        switch (dir) {
            case 0: // up
                y--;
                break;
            case 1: // down
                y++;
                break;
            case 2: // left
                x--;
                break;
            case 3: // right
                x++;
                break;
            default:
                break;
        }
    }

}

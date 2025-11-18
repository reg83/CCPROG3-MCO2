public class RegularZombie extends Zombie {
    /**
     * Constructor for RegularZombie
     * @param name Name of the RegularZombie
     * @param hp Health points of the RegularZombie
     * @param maxHp Maximum health points of the RegularZombie
     * @param atk Attack power of the RegularZombie
     * @param lvl Level of the RegularZombie
     * @param x X coordinate of the RegularZombie
     * @param y Y coordinate of the RegularZombie
     */
    public RegularZombie(String name, float hp, float maxHp, float atk, int lvl, int x, int y, String type, int dr) {
        super(name, hp, maxHp, atk, lvl, x, y, "Regular", 3);
    }
}

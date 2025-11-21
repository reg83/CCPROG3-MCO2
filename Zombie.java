class Zombie extends Character {

    protected String type;
    protected int detectRange;
    /**
     * Constructor for Class Zombie
     * @param name Name of the Zombie
     * @param hp Health Points of the Zombie
     * @param maxHp Maximum Health Points of the Zombie
     * @param atk Attack Power of the Zombie
     * @param x X-coordinate of the Zombie's position
     * @param y Y-coordinate of the Zombie's position
     * @param type Type of the Zombie
     * @param dr Detection Range of the Zombie
     */
    public Zombie(String name, float hp, float maxHp, float atk, int x, int y, String type, int dr){
        super(name, hp, maxHp, atk, x, y);
        this.type = type;
        this.detectRange = dr;
    }

    public String getType(){
        return type;
    }
    public int getDetectRange(){
        return detectRange;
    }

    public void attackPlayer(Hero h){
        h.hp -= this.atk;
        System.out.println(this.name + " attacked " + h.name + " for " + this.atk + " damage!");
        if (h.hp < 0) {
            h.hp = 0;
        }
    }

    public void detectPlayer(Hero h){
        int distance = Math.abs(this.x - h.x) + Math.abs(this.y - h.y);
        if (distance <= this.detectRange) {
            System.out.println(this.name + " has detected " + h.name + "!");
        } else {
            System.out.println(this.name + " has not detected " + h.name + ".");
        }
    }
}

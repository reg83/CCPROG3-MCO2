public class Hero extends Character {
    /**
     * Constructor for Class Hero
     * @param name Name of the Hero
     * @param hp Health Points of the Hero
     * @param maxHp Maximum Health Points of the Hero
     * @param atk Attack Power of the Hero
     * @param x X-coordinate of the Hero's position
     * @param y Y-coordinate of the Hero's position
     */
    public Hero(String name, float hp, float maxHp, float atk, int x, int y){
        super(name, hp, maxHp, atk, x, y);
    }

    /**
     * Method for the Hero to drop bomb in a dungeon
     * @param d The dungeon where the bomb is dropped   
     */
    public void dropBomb(Dungeon d, Bomb b) {
        System.out.println(name + " has dropped a bomb in dungeon " + d.getName() + " at position (" + x + ", " + y + ").");
        d.placeBomb(x, y, b);
        b.detonate(d, d.walls);
        b.explode(d, x, y);
    }

    public void heal(Potion p){
        this.hp += p.getHealingAmount();
        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public void powerup(Powerup pup){
        // choose randomly between hp and atk to increase
        if (Math.random() < 0.5) {
            pup.increaseHp(this);
        } else {
            pup.increaseAtk(this);
        }
    }

}
    

    


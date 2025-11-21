public class MageZombie extends Zombie {

    private int range;

    public MageZombie(String name, float hp, float maxHp, float atk, int x, int y, String type, int dr, int range) {
        super(name, hp, maxHp, atk, x, y, "Mage", 4);
        this.range = range;
    }

    public void shootFireball(Hero h) {
        int distance = Math.abs(this.x - h.x) + Math.abs(this.y - h.y);
        if (distance <= this.range) {
            h.hp -= this.atk;
            System.out.println(this.name + " shot a fireball at " + h.name + " for " + this.atk + " damage!");
            if (h.hp < 0) {
                h.hp = 0;
            }
        } else {
            System.out.println(this.name + " is too far to shoot a fireball at " + h.name + ".");
        }
    }
    
}

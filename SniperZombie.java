public class SniperZombie extends Zombie {

    private int range;

    public SniperZombie(String name, float hp, float maxHp, float atk, int lvl, int x, int y, String type, int dr, int range) {
        super(name, hp, maxHp, atk, lvl, x, y, "Sniper", 5);
        this.range = range;
    }

    public void snipe(Hero h) {
        int distance = Math.abs(this.x - h.x) + Math.abs(this.y - h.y);
        if (distance <= this.range) {
            h.hp -= this.atk;
            System.out.println(this.name + " sniped " + h.name + " for " + this.atk + " damage!");
            if (h.hp < 0) {
                h.hp = 0;
            }
        } else {
            System.out.println(this.name + " is too far to snipe " + h.name + ".");
        }
    }
    
}

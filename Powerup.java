public class Powerup {
    private String name;
    private int statIncrease;

    public Powerup(String name, int statIncrease) {
        this.name = name;
        this.statIncrease = statIncrease;
    }

    public String getName() {
        return name;
    }

    public int getStatIncrease() {
        return statIncrease;
    }
    
    public void increaseHp(Hero h) {
        h.hp += statIncrease;
        if (h.hp > h.maxHp) {
            h.hp = h.maxHp;
        }
    }

    public void increaseAtk(Hero h) {
        h.atk += statIncrease;
    }

}

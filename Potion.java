public class Potion {
    private String name;
    private float healingAmount;

    public Potion(String name, float healingAmount) {
        this.name = name;
        this.healingAmount = healingAmount;
    }

    public String getName(){
        return name;
    }

    public float getHealingAmount(){
        return healingAmount;
    }

    public void use(Hero p){
        p.heal(healingAmount);
    }
}

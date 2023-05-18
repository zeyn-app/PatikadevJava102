package DefaultPackage;

public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewood;
    private String weaponName;
    private String armorName;
    private int weaponDamage;
    private int armoDefence;

    public boolean isWater() {
        return water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public void setWater(boolean water) {
        this.water = water;
    }
    public void setFirewood(boolean firewood){
        this.firewood = firewood;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public Inventory() {
        this(false, false, false);


    }

    public Inventory(boolean water, boolean food, boolean firewood) {
        this.water = water;
        this.food = food;
        this.firewood = firewood;
    }
}

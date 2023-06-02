package inventory;

public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewood;
    private boolean joker;

    public boolean isWater() {
        return water;
    }
    public boolean isFood() {
        return food;
    }
    public boolean isFirewood() {
        return firewood;
    }
    public boolean isJoker() {
        return joker;
    }
    public void setFood(boolean food) {
        this.food = food;
    }
    public void setWater(boolean water) {
        this.water = water;
    }
    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
    public void setJoker(boolean joker) {
        this.joker = joker;
    }


    public Inventory() {
        this(false, false, false, false);
    }

    public Inventory(boolean water, boolean food, boolean firewood, boolean joker) {
        this.water = water;
        this.food = food;
        this.firewood = firewood;
        this.joker = joker;
    }
}

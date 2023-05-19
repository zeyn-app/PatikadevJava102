package armors;

public abstract class Armor {
    protected int id;
    protected int defence;
    protected int money;

    public int getMoney(){
        return money;
    }
    public int getDefence(){
        return defence;
    }
    public Armor(int id, int defence, int money){
        this.id = id;
        this.defence = defence;
        this.money = money;
    }
}

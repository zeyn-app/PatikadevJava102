package Gun;

public abstract class Gun extends Item{
    int damage;
    public Gun(int id, int damage, int money){
        super(id, money);
        this.damage = damage;
    }

    public int getId(){
        return id;
    }

    public int getDamage(){
        return damage;
    }

    public int getMoney(){
        return money;
    }
}

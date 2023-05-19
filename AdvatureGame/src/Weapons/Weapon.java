package Weapons;

public abstract class Weapon {
    int id;
    int damage;
    int money;

    public Weapon(int id, int damage, int money) {
        this.id = id;
        this.damage = damage;
        this.money = money;
    }

    public int getDamage() {
        return damage;
    }

    public int getMoney() {
        return money;
    }
}

package Characters;

public abstract class Character {
    int id;
    int damage;
    int health;
    int money;
    String name;

    public Character(int id, int damage, int health, int money, String name) {
        this.id = id;
        this.name = name;
        this.damage = damage;
        this.health = health;
        this.money = money;
    }


    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public abstract void restore();

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", damage=" + damage +
                ", health=" + health +
                ", money=" + money +
                ", name='" + name + '\'' +
                '}';
    }

}

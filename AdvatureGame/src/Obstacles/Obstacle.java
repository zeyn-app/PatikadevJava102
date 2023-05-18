package Obstacles;

public abstract class Obstacle {
    protected int id;
    protected int damage;
    protected int health;
    protected int money;
    protected String name;

    public Obstacle(int id, int damage, int health, int money, String name) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
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

    public void setHealth(int health){
        this.health = health;
    }


    @Override
    public String toString() {
        return "Obstacles.Obstacle{" +
                ", id=" + id +
                ", damage=" + damage +
                ", health=" + health +
                ", money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}

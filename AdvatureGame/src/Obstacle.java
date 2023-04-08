public class Obstacle {
    private Inventory inventory;
    private int id;
    private int damage;
    private int health;
    private int money;
    private String name;

    public Obstacle(int id, int damage, int health, int money, String name) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Obstacle{" +
                "inventory=" + inventory +
                ", id=" + id +
                ", damage=" + damage +
                ", health=" + health +
                ", money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}

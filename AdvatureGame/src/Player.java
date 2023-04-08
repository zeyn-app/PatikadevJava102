public class Player {
    private Inventory inventory;
    private int id;
    private int damage;
    private int health;
    private int money;
    private String name;

    public Player(){ }
    public Player(int id, int damage, int health, int money, String name) {
        this.id = id;
        this.damage = damage;
        this.health = health;
        this.money = money;
        this.name = name;
    }

    public int getId() {
        return id;
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

    public void selectChar(){
        System.out.println("\nCharacter\tID\tDamage\tHealth\tMoney");
        System.out.println("Samurai\t\t 1\t\t 5\t\t21\t   15");
        System.out.println("Archer\t\t 2\t\t 7\t\t18\t   20");
        System.out.println("Knight\t\t 3\t\t 8\t\t24\t    5");
    }

    @Override
    public String toString() {
        return "Player{" +
                "inventory=" + inventory +
                ", id=" + id +
                ", damage=" + damage +
                ", health=" + health +
                ", money=" + money +
                ", name='" + name + '\'' +
                '}';
    }
}

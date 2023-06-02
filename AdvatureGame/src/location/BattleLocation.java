package location;

import armors.Armor;
import armors.Heavy;
import armors.Light;
import armors.Medium;
import obstacles.*;
import weapons.Gun;
import weapons.Rifle;
import weapons.Sword;
import weapons.Weapon;

import java.util.Scanner;


public abstract class BattleLocation extends Location {
    private final Obstacle obstacle;
    private String booty;
    private final int countOfObstacle;
    Scanner scanner = new Scanner(System.in);

    public BattleLocation(Obstacle obstacle) {
        this.obstacle = obstacle;
        countOfObstacle = generateObstacleCount();
        obstacle.setHealth(obstacle.getHealth() * countOfObstacle);
        obstacle.setMoney(obstacle.getMoney() * countOfObstacle);
    }

    public BattleLocation(String name, String feature, Obstacle obstacle, String booty) {
        this(obstacle);
        this.name = name;
        this.feature = feature;
        this.booty = booty;
    }


    public String getBooty() {
        return booty;
    }

    public boolean combat() {
        int damage, round;

        int whoStart = (int) (Math.random() * 100) + 1;
        // obstacle start
        round = whoStart < 50 ? 0 : 1;

        while (true) {
            System.out.println();
            if (round % 2 == 1) {
                System.out.println("\t*** " + player.getName() + " shoot " + obstacle.getName() + " ***");
                damage = (obstacle.getHealth() - player.getCharacter().getDamage());
                damage = Math.max(0, damage);
                obstacle.setHealth(damage);
            } else {
                System.out.println("\t*** " + obstacle.getName() + " shoot " + player.getName() + " ***");
                damage = player.getCharacter().getHealth() - obstacle.getDamage();
                player.getCharacter().setHealth(damage);
            }

            getInfo();
            round++;

            if (player.getCharacter().getHealth() <= 0) {
                return false;
            }

            if (obstacle.getHealth() <= 0) {
                break;
            }
        }
        System.out.println("\n\t**************************");
        System.out.println("\t" + obstacle.getName() + "(s) dead.");
        player.getCharacter().setMoney(player.getCharacter().getMoney() + obstacle.getMoney());
        System.out.println("\t" + player);
        return true;
    }


    private int generateObstacleCount() {
        int max = 3, min = 1;
        if (obstacle instanceof Snake)
            max = 5;
        return (int) (Math.random() * (max - min) + min);
    }

    private void getInfo() {
        System.out.println("\tThe health of " + player.getName() + " --> " + (Math.max(player.getCharacter().getHealth(), 0)));
        System.out.println("\tThe health of " + obstacle.getName() + " --> " + (Math.max(obstacle.getHealth(), 0)));
    }

    public boolean fight() {
        System.out.println("\tThere are " + countOfObstacle + " " + obstacle.getName() + "(s)");
        getInfo();
        System.out.print("\tDo you want to fight? (yes / no): ");
        String choice = scanner.next();

        if (choice.startsWith("y") | choice.startsWith("Y")) {
            return true;
        }
        return false;
    }

    public void winJoker() {
        int jokerRandomCategory = (int) (Math.random() * (100) + 1);
        int jokerRandomItem = (int) (Math.random() * (100) + 1);

        // weapon
        if (jokerRandomCategory <= 15) {
            Weapon weapon;
            if (jokerRandomItem <= 20) {
                weapon = new Rifle();
                jokerIsWeapon(weapon);
            } else if (jokerRandomItem <= 50) {
                weapon = new Sword();
                jokerIsWeapon(weapon);
            } else {
                weapon = new Gun();
                jokerIsWeapon(weapon);
            }

        }
        // armor
        else if (jokerRandomCategory <= 30) {
            Armor armor;
            if (jokerRandomItem <= 20) {
                armor = new Heavy();
                jokerIsArmor(armor);
            } else if (jokerRandomItem <= 50) {
                armor = new Medium();
                jokerIsArmor(armor);
            } else {
                armor = new Light();
                jokerIsArmor(armor);
            }
        }
        // money
        else if (jokerRandomCategory <= 55) {
            int playerMoney = player.getCharacter().getMoney();
            if (jokerRandomItem <= 20) {
                player.getCharacter().setMoney(playerMoney + 10);

            } else if (jokerRandomItem <= 50) {
                player.getCharacter().setMoney(playerMoney + 5);
            } else {
                player.getCharacter().setMoney(playerMoney + 1);
            }
            System.out.println("\tYou won " + playerMoney + " money");
            System.out.println(player.getCharacter());
        }
        // nothing
        else {
            System.out.println("\tYou won nothing");
        }
    }

    private void jokerIsArmor(Armor armor){
        int health = player.getCharacter().getHealth();
        player.getCharacter().setHealth(health + armor.getDefence());
        System.out.println("\tYou won " + armor.getDefence() + " defence");
        System.out.println("\t" + player.getCharacter());
    }

    private void jokerIsWeapon(Weapon weapon){
        int damage = player.getCharacter().getDamage();
        player.getCharacter().setDamage(damage + weapon.getDamage());
        System.out.println("\tYou won " + weapon.getDamage() + " damage");
        System.out.println(player.getCharacter());
    }
}

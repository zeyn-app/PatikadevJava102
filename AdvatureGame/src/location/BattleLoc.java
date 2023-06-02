package location;

import obstacles.*;

import java.util.Scanner;


public abstract class BattleLoc extends Location {
    private final Obstacle obstacle;
    private String booty;
    private final int countOfObstacle;
    Scanner scanner = new Scanner(System.in);

    public BattleLoc(Obstacle obstacle) {
        this.obstacle = obstacle;
        countOfObstacle = generateObstacleCount();
        obstacle.setHealth(obstacle.getHealth() * countOfObstacle);
        obstacle.setMoney(obstacle.getMoney() * countOfObstacle);
    }

    public BattleLoc(String name, String feature, Obstacle obstacle, String booty) {
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
        // System.out.println("who start first: " + whoStart);
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
        //System.out.println("\tYour current money: " + player.getCharacter().getMoney());
        System.out.println("\t" + player.getCharacter());
        return true;
    }


    private int generateObstacleCount() {
        return (int) (Math.random() * 3 + 1);
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

        if (choice.startsWith("y") || choice.startsWith("Y")) {
            return true;
        }
        return false;
    }
}

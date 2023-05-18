package Location;

import Characters.Character;
import Obstacles.*;


public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String booty;
    private int countOfObstacle;

    public BattleLoc(Obstacle obstacle) {
        this.obstacle = obstacle;
        countOfObstacle = generateObstacleCount();
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

    public Obstacle getObstacle() {
        return obstacle;
    }

    public int getCountOfOstacle() {
        return countOfObstacle;
    }

    public boolean onLocation() {
        return true;
    }

    public boolean canCombat() {
        Character character = player.getCharacter();
        int damage, round = 1, health, money;
        money = obstacle.getMoney() * countOfObstacle;
        health = obstacle.getHealth() * countOfObstacle;
        obstacle.setHealth(health);

        int gainProbabilityOfPlayer, gainProbabilityOfObstacle;
        gainProbabilityOfPlayer = character.getHealth() / obstacle.getDamage();
        gainProbabilityOfObstacle = obstacle.getHealth() / character.getDamage();

        if (gainProbabilityOfPlayer < gainProbabilityOfObstacle) {
            System.out.println("You dont have enough power to combat, plase come back to get power or restore your health");
            return false;
        }

        System.out.println("\tThe health of " + player.getName() + " --> " + character.getHealth());
        System.out.println("\tThe health of " + obstacle.getName() + " --> " + obstacle.getHealth());
        while (obstacle.getHealth() > 0) {

            System.out.println();
            if (round % 2 == 1) {
                System.out.println("\t*** " + player.getName() + " shoot " + obstacle.getName() + " ***");
                damage = (obstacle.getHealth() - character.getDamage());
                damage = Math.max(0, damage);
                obstacle.setHealth(damage);
            } else {
                System.out.println("\t*** " + obstacle.getName() + " shoot " + player.getName() + " ***");
                damage = character.getHealth() - obstacle.getDamage();
                character.setHealth(damage);
            }
            System.out.println("\tThe health of " + player.getName() + " --> " + character.getHealth());
            System.out.println("\tThe health of " + obstacle.getName() + " --> " + obstacle.getHealth());
            round++;
        }
        System.out.println("\n\t**************************");
        System.out.println("\t" + obstacle.getName() + " is dead. You earned " + money + " money");
        character.setMoney(character.getMoney() + money);
        System.out.println("\tYour current money: " + character.getMoney());
        return true;
    }


    private int generateObstacleCount() {
        return (int) (Math.random() * 3 + 1);
    }
}

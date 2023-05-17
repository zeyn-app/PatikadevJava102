package Location;

import Obstacles.*;


public abstract class BattleLoc extends Location{
    protected Obstacle obstacle;
    String botty;
    int countOfOstacle;

    public BattleLoc(Obstacle obstacle){
        this.obstacle = obstacle;
        countOfOstacle = generateObstacleCount();
    }

    public BattleLoc(String name, String feature, Obstacle obstacle, String botty) {
        this(obstacle);
        this.name = name;
        this.feature = feature;
        this.botty = botty;
    }


    public String getBotty() {
        return botty;
    }

    public int getCountOfOstacle(){
        return countOfOstacle;
    }

    public boolean onLocation() {
        return true;
    }

    public void combat() {
        int damage = (player.getCharacter().getDamage() - obstacle.getDamage())*countOfOstacle;
        player.getCharacter().setDamage(damage);
    }



    public int generateObstacleCount() {
        return (int) (Math.random() * 3 + 1);
    }


}

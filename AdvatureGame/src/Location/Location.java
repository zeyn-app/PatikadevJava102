package Location;


import DefaultPackage.Player;

public abstract class Location {
    protected String name;
    protected String feature;
    Player player;
    boolean onLocation;
    public void setPlayer(Player player){
        this.player = player;
    }

    @Override
    public String toString(){
        return "Location name: " + name + "\nProperty: " + feature;
    }
}
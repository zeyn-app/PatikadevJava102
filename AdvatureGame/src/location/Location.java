package location;


import player.Player;

public abstract class Location {
    protected String name;
    protected String feature;
    Player player;

    public void setPlayer(Player player){
        this.player = player;
    }
    public String getName(){
        return name;
    }

    @Override
    public String toString(){
        return "Location name: " + name + "\nProperty: " + feature;
    }
}

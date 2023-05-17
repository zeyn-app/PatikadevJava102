package Location;

import Obstacles.Zombie;

public class Cave extends BattleLoc {
    public Cave(){
        super("Cave", "Fight + Loot", new Zombie(), "Food");
    }
}

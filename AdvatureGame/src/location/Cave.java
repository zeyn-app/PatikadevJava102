package location;

import obstacles.Zombie;

public class Cave extends BattleLocation {
    public Cave(){
        super("Cave", "Fight + Loot", new Zombie(), "Food");
    }
}

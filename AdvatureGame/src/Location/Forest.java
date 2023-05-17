package Location;

import Obstacles.Vampire;
public class Forest extends BattleLoc {
    public Forest() {
        super("Forest", "Fight + Loot", new Vampire(), "Firewood");
    }
}

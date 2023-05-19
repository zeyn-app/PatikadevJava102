package location;

import obstacles.Vampire;
public class Forest extends BattleLoc {
    public Forest() {
        super("Forest", "Fight + Loot", new Vampire(), "Firewood");
    }
}

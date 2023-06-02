package location;

import obstacles.Vampire;
public class Forest extends BattleLocation {
    public Forest() {
        super("Forest", "Fight + Loot", new Vampire(), "Firewood");
    }
}

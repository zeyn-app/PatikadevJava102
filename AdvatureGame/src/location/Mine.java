package location;
import obstacles.Bear;
import obstacles.Snake;

public class Mine extends BattleLocation {
    public Mine() {
        super("Mine", "Fight + Loot", new Snake(), "Joker Price");
    }
}

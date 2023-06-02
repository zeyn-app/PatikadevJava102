package location;

import armors.Armor;
import armors.Heavy;
import armors.Light;
import armors.Medium;
import obstacles.Snake;
import player.Player;
import weapons.Gun;
import weapons.Rifle;
import weapons.Sword;
import weapons.Weapon;

public class Mine extends BattleLoc {
    public Mine() {
        super(new Snake());

    }

    public void winJoker(Player player) {
        int jokerRandomCategory = (int) (Math.random() * (100) + 1);
        int jokerRandomItem = (int) (Math.random() * (100) + 1);

        //System.out.println("1: " + jokerRandomCategory + "\n2: " + jokerRandomItem);

        // weapon
        if (jokerRandomCategory <= 15) {
            Weapon weapon;
            if (jokerRandomItem <= 20) {
                weapon = new Rifle();
                jokerIsWeapon(player, weapon);
            } else if (jokerRandomItem > 20 && jokerRandomItem <= 50) {
                weapon = new Sword();
                jokerIsWeapon(player, weapon);
            } else {
                weapon = new Gun();
                jokerIsWeapon(player, weapon);
            }

        }
        // armor
        else if (jokerRandomCategory > 15 & jokerRandomCategory <= 30) {
            Armor armor;
            if (jokerRandomItem <= 20) {
                armor = new Heavy();
                jokerIsArmor(player, armor);
            } else if (jokerRandomItem > 20 && jokerRandomItem <= 50) {
                armor = new Medium();
                jokerIsArmor(player, armor);
            } else {
                armor = new Light();
                jokerIsArmor(player, armor);
            }
        }
        // money
        else if (jokerRandomCategory > 30 & jokerRandomCategory <= 55) {
            int playerMoney = player.getCharacter().getMoney();
            if (jokerRandomItem <= 20) {
                player.getCharacter().setMoney(playerMoney + 10);

            } else if (jokerRandomItem > 20 && jokerRandomItem <= 50) {
                player.getCharacter().setMoney(playerMoney + 5);
            } else {
                player.getCharacter().setMoney(playerMoney + 1);
            }
            System.out.println("\tYou won " + playerMoney + " money");
            System.out.println(player.getCharacter());
        }
        // nothing
        else {
            System.out.println("\tYou won nothing");
        }
    }

    private void jokerIsArmor(Player player, Armor armor){
        int health = player.getCharacter().getHealth();
        player.getCharacter().setHealth(health + armor.getDefence());
        System.out.println("\tYou won " + armor.getDefence() + " defence");
        System.out.println("\t" + player.getCharacter());
    }

    private void jokerIsWeapon(Player player, Weapon weapon){
        int damage = player.getCharacter().getDamage();
        player.getCharacter().setDamage(damage + weapon.getDamage());
        System.out.println("\tYou won " + weapon.getDamage() + " damage");
        System.out.println(player.getCharacter());
    }
}

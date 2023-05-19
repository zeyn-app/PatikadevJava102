package location;

import armors.Armor;
import armors.Heavy;
import armors.Light;
import armors.Medium;
import weapons.*;

import java.util.Scanner;

public class ToolStore extends NormalLoc {

    public ToolStore() {
        super("Tool Store", "Get supported items");
    }

    @Override
    public boolean onLocation() {
        return super.onLocation();
    }

    public void menu() {
        System.out.println("\t****** Welcome to the Tool Store ******\n\tThe items on the Tool Store: \n\t1-Armors --> get defence\n\t2-Weapons --> get damage\n\t3-Exit");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please choose a item: ");
        String choice = scanner.next();

        if (choice.equalsIgnoreCase("armors") || choice.equalsIgnoreCase("1")) {
            Armor armor;
            System.out.println("\n\tArmors\t \tID\tDefence \tMoney\n" +
                    "\t1-Light\t\t 1\t\t 1\t\t15\n" +
                    "\t2-Medium\t 2\t\t 3\t\t25\n" +
                    "\t3-Heavy\t\t 3\t\t 5\t\t40\n" +
                    "\t4-Back");
            System.out.print("\tChoose an item: ");
            choice = scanner.next();
            switch (choice) {
                case "1", "light" -> {
                    armor = new Light();
                    Light light = (Light) armor;
                    System.out.print("Buy or Leave: ");
                    choice = scanner.next();
                    if (choice.equalsIgnoreCase("buy")) {
                        buy(light);
                        System.out.println(player);
                    }
                }
                case "2", "medium" -> {
                    armor = new Medium();
                    Medium medium = (Medium) armor;
                    System.out.print("\tBuy or Leave: ");
                    choice = scanner.next();
                    if (choice.equalsIgnoreCase("buy")) {
                        buy(medium);
                        System.out.println(player);
                    }
                }
                case "3", "heavy" -> {
                    armor = new Heavy();
                    Heavy heavy = (Heavy) armor;
                    System.out.print("\tBuy or Leave: ");
                    choice = scanner.next();
                    if (choice.equalsIgnoreCase("buy")) {
                        buy(heavy);
                        System.out.println(player);
                    }
                }
                case "4", "back" -> {
                }
                default -> {
                    System.out.println("Yanlış seçim yapıldı, sanırım exception fırlatmam gerekiyor");
                    // Throw exception
                }
            }
        } else if (choice.equalsIgnoreCase("weapons") || choice.equalsIgnoreCase("2")) {
            Weapon weapon;
            System.out.println("\n\tWeapons\t \tID\tDamage\tMoney\n" +
                    "\t1-Gun\t\t 1\t\t 2\t\t25\n" +
                    "\t2-Sword\t\t 2\t\t 3\t\t35\n" +
                    "\t3-Rifle\t\t 3\t\t 7\t\t45\n" +
                    "\t4-Back");
            System.out.print("\tChoose an item: ");
            choice = scanner.next();
            switch (choice) {
                case "1", "gun" -> {
                    weapon = new Gun();
                    Gun gun = (Gun) weapon;
                    System.out.print("\tBuy or Leave: ");
                    choice = scanner.next();
                    if (choice.equalsIgnoreCase("buy")) {
                        buy(gun);
                        System.out.println(player);
                    }
                }
                case "2", "sword" -> {
                    weapon = new Sword();
                    Sword sword = (Sword) weapon;
                    System.out.print("\tBuy or Leave: ");
                    choice = scanner.next();
                    if (choice.equalsIgnoreCase("buy")) {
                        buy(sword);
                        System.out.println(player);
                    }
                }
                case "3", "rifle" -> {
                    weapon = new Rifle();
                    Rifle rifle = (Rifle) weapon;
                    System.out.print("\tBuy or Leave: ");
                    choice = scanner.next();
                    if (choice.equalsIgnoreCase("buy")) {
                        buy(rifle);
                        System.out.println(player);
                    }
                }
                case "4", "back" -> {
                }
                default -> {
                    System.out.println("Yanlış seçim yapıldı, sanırım exception fırlatmam gerekiyor");
                    // Throw exception
                }
            }
        } else {
            System.out.println("Yanlış seçim yaptınız"); // Exception fırlatılabilir
        }
        // }
    }

    public void buy(Armor armor) {
        if (armor.getMoney() <= player.getCharacter().getMoney()) {
            int money = player.getCharacter().getMoney();
            int health = player.getCharacter().getHealth();
            player.getCharacter().setMoney(money - armor.getMoney());
            player.getCharacter().setHealth(health + armor.getDefence());
        } else {
            System.out.println("You don't have enough money");
        }
    }

    public void buy(Weapon weapon) {
        if (weapon.getMoney() <= player.getCharacter().getMoney()) {
            int money = player.getCharacter().getMoney();
            int damage = player.getCharacter().getDamage();
            player.getCharacter().setMoney(money - weapon.getMoney());
            player.getCharacter().setDamage(damage + weapon.getDamage());
        } else {
            System.out.println("You don't have enough money");
        }
    }
}

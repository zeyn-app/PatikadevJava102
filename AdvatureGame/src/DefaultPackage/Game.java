package DefaultPackage;

import Location.*;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Location location;
    private Player player;

    public void start() {
        print("Welcome! Game is starting...");
        print("Enter your name: ");
        String name = scanner.next();
        player = new Player(name);

        player.selectChar();
        System.out.println(player);
        selectLocation();
    }


    public void selectLocation() {
        while (!player.getInventory().isFood() || !player.getInventory().isWater() || !player.getInventory().isFirewood()) {

            print("\nLOCATION\n1-Battle Location\n2-Normal Location\n3-Exit");
            String chooseLocation;
            print("Please choose your location where you want to go: ");
            chooseLocation = scanner.next();

            if (chooseLocation.equals("1") || chooseLocation.equalsIgnoreCase("Battle LocatIon")) {
                print("\t=====================================");
                print("  \tLocation\tObstacle\tBooty\n" +
                        "\t1-Cave\t\tZombie\t\tFood\n" +
                        "\t2-Forest\tVampire\t\tFirewood\n" +
                        "\t3-River\t\tBear\t\tWater\n" +
                        "\t4-Back");
                print("\t=====================================");
                innerLoop:
                while (!player.getInventory().isFood() || !player.getInventory().isWater() || !player.getInventory().isFirewood()) {
                    boolean hasBooty;
                    print("Please enter the name of location: ");
                    chooseLocation = scanner.next();
                    switch (chooseLocation) {
                        case "1", "cave", "Cave", "CAVE" -> {
                            location = new Cave();
                            Cave cave = (Cave) location;
                            hasBooty = player.getInventory().isFood();
                            if (canVisit(cave, hasBooty))
                                player.getInventory().setFood(true);
                        }

                        case "2", "forest", "Forest", "FOREST" -> {
                            location = new Forest();
                            Forest forest = (Forest) location;
                            hasBooty = player.getInventory().isFirewood();
                            if (canVisit(forest, hasBooty))
                                player.getInventory().setFirewood(true);
                        }
                        case "3", "river", "River", "RIVER" -> {
                            location = new River();
                            River river = (River) location;
                            hasBooty = player.getInventory().isWater();
                            if (canVisit(river, hasBooty))
                                player.getInventory().setWater(true);
                        }
                        case "4", "back", "Back", "BACK" -> {
                            break innerLoop;
                        }
                        default -> {
                            System.out.println("Yanlış seçim yapıldı, sanırım exception fırlatmam gerekiyor");
                            // Throw exception
                        }

                    }
                }

            } else if (chooseLocation.equals("2") || chooseLocation.equalsIgnoreCase("Normal LocatIon")) {
                print("\t=====================================");
                print("\tLocation\t \tFeature\n" +
                        "\t1-Safe House\tRestore\n" +
                        "\t2-Tool Store\tBuy Weapon/Defence\n" +
                        "\t3-Back");
                print("\t=====================================");
                innerLoop:
                while (true) {
                    print("Please enter the name of location: ");
                    chooseLocation = scanner.next();
                    switch (chooseLocation) {
                        case "1", "Safe House", "safe house" -> {
                            location = new SafeHouse();
                            location.setPlayer(player);
                            print("Restoring...");
                            player.getCharacter().restore();
                            break innerLoop;
                        }
                        case "2", "Tool Store" -> {
                            location = new ToolStore();
                            location.setPlayer(player);
                            ((ToolStore) location).menu();
                            break innerLoop;
                        }
                        case "3", "back", "Back", "BACK" -> {
                            break innerLoop;
                        }
                        default -> {
                            System.out.println("Yanlış seçim yapıldı, sanırım exception fırlatmam gerekiyor");
                            // Throw exception
                        }
                    }
                }
            }else if(chooseLocation.equals("3") || chooseLocation.equalsIgnoreCase("EXIT")){
                break;
            }

            //if(player.getInventory().isWater()&& player.getInventory().isFood()&& player.getInventory().isFirewood())
                //break;
        }
    }

    public void print(String str) {
        System.out.print("\n" + str);
    }

    public boolean canVisit(BattleLoc location, boolean hasBooty) {
        boolean result = false;
        if (!hasBooty) {
            location.setPlayer(player);
            print("There are " + location.getCountOfOstacle() + " " + location.getObstacle().getName() + "(s)");
            print("Do you want to fight? (yes / no): ");
            String choice = scanner.next();
            if (choice.startsWith("y") || choice.startsWith("Y")) {
                result = location.canCombat();
            }
        } else {
            System.out.println("You have " + location.getBooty() + ", you can not visit " + location.getName());
            return false;
        }
        return result;
    }
}

package game;

import player.Player;
import location.*;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Location location;
    private Player player;
    private boolean isAlive = true;

    public void start() {
        print("Welcome! Game is starting...");
        print("Enter your name: ");
        String name = scanner.next();
        player = new Player(name);

        player.selectChar();
        selectLocation();

        if (isAlive) System.out.println("***********  Winner  ***********");
        else System.out.println("\t...GAME OVER!!!");
    }


    public void selectLocation() {
        while ((!player.getInventory().isFood() || !player.getInventory().isWater() || !player.getInventory().isFirewood() || !player.getInventory().isJoker()) && isAlive) {

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
                        "\t4-Mine\t\tSnake\t\tJoker\n" +
                        "\t5-Back");
                print("\t=====================================");
                innerLoop:
                while ((!player.getInventory().isFood() || !player.getInventory().isWater() || !player.getInventory().isFirewood() || !player.getInventory().isJoker()) && isAlive) {
                    boolean hasBooty;
                    print("Please enter the name of location: ");
                    chooseLocation = scanner.next();
                    switch (chooseLocation) {
                        case "1", "cave", "Cave", "CAVE" -> {
                            location = new Cave();
                            Cave cave = (Cave) location;
                            hasBooty = player.getInventory().isFood();
                            if (visit(cave, hasBooty))
                                player.getInventory().setFood(true);
                        }

                        case "2", "forest", "Forest", "FOREST" -> {
                            location = new Forest();
                            Forest forest = (Forest) location;
                            hasBooty = player.getInventory().isFirewood();
                            if (visit(forest, hasBooty))
                                player.getInventory().setFirewood(true);
                        }
                        case "3", "river", "River", "RIVER" -> {
                            location = new River();
                            River river = (River) location;
                            hasBooty = player.getInventory().isWater();
                            if (visit(river, hasBooty))
                                player.getInventory().setWater(true);
                        }
                        case "4", "mine", "Mine", "MINE" -> {
                            location = new Mine();
                            Mine mine = (Mine) location;
                            hasBooty = player.getInventory().isJoker();
                            if (visit(mine, hasBooty)&isAlive) {
                                mine.winJoker();
                                player.getInventory().setJoker(true);
                            }
                        }
                        case "5", "back", "Back", "BACK" -> {
                            break innerLoop;
                        }
                        default -> System.out.println("Yanlış seçim yapıldı, sanırım exception fırlatmam gerekiyor");
                        // Throw exception
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
                            System.out.println(player);
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
                        default -> System.out.println("Yanlış seçim yapıldı, sanırım exception fırlatmam gerekiyor");
                        // Throw exception
                    }
                }
            } else if (chooseLocation.equals("3") || chooseLocation.equalsIgnoreCase("EXIT")) {
                break;
            }
        }
    }

    public void print(String str) {
        System.out.print("\n" + str);
    }

    public boolean visit(BattleLocation location, boolean hasBooty) {
        if (!hasBooty) {
            location.setPlayer(player);
            if (location.fight()) {
                isAlive = location.combat();
                return true;
            }
        } else
            System.out.println("You have " + location.getBooty() + ", you can not visit " + location.getName());
        return false;
    }
}

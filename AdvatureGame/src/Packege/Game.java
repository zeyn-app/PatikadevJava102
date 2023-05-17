package Packege;

import Location.*;

import java.util.Scanner;

public class Game {
    Scanner scanner = new Scanner(System.in);
    private Location location;
    private Player player;

    public void start() {
        print("Welcome! Game is starting...");
        player = new Player();

        player.selectChar();
        System.out.println(player);
        selectLocation();
        System.out.println(location);

    }


    public void selectLocation() {
        print("\nLOCATION\n1-Battle Location\n2-Normal Location");
        String chooseLocation;
        print("Please choose your location where you want to go" +  (chooseLocation = scanner.next()));
        //chooseLocation = scanner.next();

        if (chooseLocation.equals("1") || chooseLocation.equalsIgnoreCase("Battle LocatIon")) {
            print("\t=====================================");
            print("  \tLocation\tObstacle\tBooty\n" +
                    "\t1-Cave\t\tZombie\t\tFood\n" +
                    "\t2-Forest\tVampire\t\tFirewood\n" +
                    "\t3-River\t\tBear\t\tWater\n");
            chooseLocation = scanner.next();
            switch (chooseLocation) {
                case "1" -> {
                    location = new Cave();
                    location.setPlayer(player);
                    print("There are " + ((Cave) location).getCountOfOstacle() + " Zombie");
                    print("Do you want to fight? (y/n)");
                    String choice = scanner.nextLine();
                    if (choice.startsWith("y") || choice.startsWith("Y")) {
                        ((Cave) location).combat();
                        System.out.println(player);
                    }
                }
                case "2" -> {
                    location = new Forest();
                    location.setPlayer(player);
                }
                case "3" -> {
                    location = new River();
                    location.setPlayer(player);
                }
                default -> {
                    // Throw exception
                }

            }
        } else if (chooseLocation.equals("2") || chooseLocation.equalsIgnoreCase("Normal LocatIon")) {
            print("\t=====================================");
            print("\tLocation\t \tFeature\n" +
                    "\t1-Safe House\tRestore\n" +
                    "\t2-Tool Store\tBuy Gun/Defence\n");
            chooseLocation = scanner.next();
            switch (chooseLocation) {
                case "1" -> {
                    location = new SafeHouse();
                    location.setPlayer(player);
                    print("Restoring...");
                    player.getCharacter().restore();
                }
                case "2" -> {
                    location = new ToolStore();
                    location.setPlayer(player);
                    ((ToolStore) location).menu();
                }

                default -> {
                    // Throw exception
                }
            }
        }
    }

    public void print(String str) {
        System.out.println(str);
    }
}

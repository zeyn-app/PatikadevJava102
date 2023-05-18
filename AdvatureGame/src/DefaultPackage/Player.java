package DefaultPackage;

import java.util.Scanner;

import Characters.*;
import Characters.Character;

public class Player {
    Scanner scanner = new Scanner(System.in);

    private Character character;
    private final Inventory inventory;
    private String name;

    public Character getCharacter() {
        return character;
    }

    public Inventory getInventory() {
        return inventory;
    }
    public String getName(){return name;}

    public Player(String name){
        this.name = name;
        inventory = new Inventory();
    }

    public void selectChar() {
        String choice;
        System.out.println("The characters and their properties are shown below.");
        System.out.println("\nCharacter\t \tID\tDamage\tHealth\tMoney\n" +
                "1-Samurai\t\t 1\t\t 5\t\t21\t   15\n" +
                "2-Archer\t\t 2\t\t 7\t\t18\t   20\n" +
                "3-Knight\t\t 3\t\t 8\t\t24\t    5\n");
        System.out.print("Please choose your character: ");
        choice = scanner.next();

        switch (choice) {
            case "1" -> character = new Samurai();
            case "2" -> character = new Archer();
            case "3" -> character = new Knight();
            default -> character = null; // Buraya exceptionları ekle
        }
    }

    @Override
    public String toString() {
        return character.toString();
    }
}

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);

        player.selectChar();
        System.out.print("\nChoose Your Character: ");
        String character = scanner.nextLine();

        if(character.equalsIgnoreCase("samurai")){
            player = new Samurai();
        }
        else if(character.equalsIgnoreCase("archer")){
            player = new Archer();
        }
        else if(character.equalsIgnoreCase("knight")){
            player = new Knight();
        }
        else{
            System.out.println("Wrong choice");
            return;
        }

        System.out.println(player.toString());

    }
}
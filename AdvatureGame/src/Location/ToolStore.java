package Location;

import Gun.*;

import java.util.Scanner;

public class ToolStore extends NormalLoc {

    public ToolStore(){
        super("Tool Store", "Get supported items");
    }

    @Override
    public boolean onLocation() {
        return super.onLocation();
    }

    public void menu(){
        System.out.println("****** Mağazaya hoşgeldiniz ******\nMağazamızda bulunan ürünler: \nSilahlar(s)\nZırhlar(z)");
        Scanner scanner = new Scanner(System.in);
        String choose = scanner.next();

        if(choose.startsWith("s") || choose.startsWith("S")){
            Gun gun = null;
            System.out.println("\n\t1-Tabanca\n\t2-Kılıç\n\t3-Tüfek" );
            choose = scanner.next();
            switch (choose){
                case "1"-> {gun = new Pistol(); buy(gun);}
                default -> System.out.println("Yanlış seçim yaptınız");
            }
        }
        else if(choose.startsWith("z") || choose.startsWith("Z")){
            Gun gun = null;
            System.out.println("\n\t1-Hafif\n\t2-Orta\n\t3-Ağır" );
            choose = scanner.next();
            switch (choose){
                case "1"-> gun = new Pistol();
                default -> System.out.println("Yanlış seçim yaptınız");
            }
        }
        else{
            System.out.println("Yanlış seçim yaptınız");
        }

    }

    public void buy(Gun gun){
       player.getCharacter().powered(gun);
    }
}

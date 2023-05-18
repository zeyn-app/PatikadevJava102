package Characters;

public class Samurai extends Character {
    public Samurai(){
        super(1, 5, 21, 15, "Samurai");
    }

    public void restore(){
        health = 21;
    }
}
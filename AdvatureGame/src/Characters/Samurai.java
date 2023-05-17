package Characters;

public class Samurai extends Character {
    public Samurai(){
        super(1, 5, 21, 15, "Samurai");
    }

    public void restore(){
        damage = 5;
        health = 21;
        money = 15;
    }
}
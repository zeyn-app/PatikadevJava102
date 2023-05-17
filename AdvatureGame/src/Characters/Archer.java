package Characters;

public class Archer extends Character {
    public Archer(){
        super(2, 7, 18, 20, "Archer");
    }

    public void restore(){
        damage = 7;
        health = 18;
        money = 20;
    }
}

package characters;

public class Archer extends Character {
    public Archer(){
        super(2, 7, 18, 20, "Archer");
    }

    public void restore(){
        health = 18;
    }
}

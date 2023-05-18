package Characters;

public class Knight extends Character{

    public Knight(){
        super(3, 8, 24, 5, "Knight");
    }

    public void restore(){
        damage = 8;
        health = 24;
        money = 5;
    }
}

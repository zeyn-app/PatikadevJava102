package characters;

public class Knight extends Character{

    public Knight(){
        super(3, 8, 24, 5, "Knight");
    }

    public void restore(){
        health = 24;
    }
}

package obstacles;

public class Snake extends Obstacle {
    //??????private int damage = (int) (Math.random() * (6 - 3 + 1)) + 3;
    public Snake() {
        super(4, (int) (Math.random() * (6 - 3 + 1)) + 3, 12, 0,"Snake");
    }


}

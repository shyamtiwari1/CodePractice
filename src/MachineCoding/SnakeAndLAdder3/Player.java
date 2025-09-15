package MachineCoding.SnakeAndLAdder3;

public class Player {

    String name ;
    int position ;


    public Player(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int nextpost) {
        this.position = nextpost;
    }
}

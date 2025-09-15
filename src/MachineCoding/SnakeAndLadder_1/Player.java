package MachineCoding.SnakeAndLadder_1;

public class Player {

    String name;
    int position;

    public Player(String name){
        this.name = name;
    }

    public int setPosition(int x ) {
        this.position = x;
        return x;

    }

    public int getPosition() {
        return position!=0?position:0;
    }

    public String getName() {
        return name;
    }
}

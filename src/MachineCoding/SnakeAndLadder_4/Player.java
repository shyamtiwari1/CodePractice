package MachineCoding.SnakeAndLadder_4;

public class Player {

    String name ;
    int position ;

    public Player(String name){
        this.name = name;
        this.position = 0 ;

    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int nextPos) {
        this.position = nextPos;
    }
}

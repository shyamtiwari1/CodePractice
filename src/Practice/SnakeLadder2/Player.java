package Practice.SnakeLadder2;

public class Player {

    private String name ;
    private int position;


    public Player(String name ){
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int nextpos) {
        this.position = nextpos;
    }

    public String getName() {
        return name;
    }
}

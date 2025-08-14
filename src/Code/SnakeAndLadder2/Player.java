package Code.SnakeAndLadder2;


public class Player {

    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(int position) {
        this.position = position;
    }



    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


}

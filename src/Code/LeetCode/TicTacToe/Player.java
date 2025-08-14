package Code.LeetCode.TicTacToe;

public class Player {

    public String name;
    public Symbol symbol;

    public Player(String shyam, Symbol symbol) {
        this.name = shyam;
        this.symbol = symbol;
    }


    public String getName(){
        return name;
    }

    public Symbol getSymbol(){
        return symbol;

    }




}

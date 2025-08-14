package Code.LeetCode.TicTacToe;

public class Cell {


    public int row ;
    public int col;
    public Symbol symbol;


    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.symbol = null;

    }

    public boolean isEmpty() {
        return symbol== null;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }


}

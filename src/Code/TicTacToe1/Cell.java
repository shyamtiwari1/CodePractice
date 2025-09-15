package Code.TicTacToe1;

public class Cell {

    int row;
    int column;

    Symbol symbol;


    public Cell(int row , int column ){
        this.column = column;
        this.row = row;
        this.symbol = null;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public Symbol getSymbol() {
        return symbol;
    }
}

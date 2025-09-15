package MachineCoding.TicTacToe;

public class Cell {
    int row;
    int column ;

    Symbol value;

    public Cell(int i, int j) {
        this.row = i ;
        this.column = j;
        this.value = null;
    }

    public void setValue(Symbol value) {
        this.value = value;
    }



    public Symbol getSymbol() {
        return value;
    }
}

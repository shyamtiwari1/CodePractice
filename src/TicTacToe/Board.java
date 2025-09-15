package TicTacToe;

public class Board {
    int size;
    Cell[][] grid;

    public Board(int size) {
        this.size = size;
        grid = new Cell[size][size];
        for(int i = 0 ; i < size;i++){
            for(int j = 0 ; j < size;j++){
                grid[i][j] = new Cell(i,j);

            }
        }
    }

    public void printBoard() {
        System.out.println();
        for(int i = 0 ; i < size;i++){
            for(int j = 0 ; j < size;j++){

                System.out.print(grid[i][j].getSymbol()!=null?grid[i][j].getSymbol():"-"+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean checkValidityAndPlaceMove(int row, int col , Symbol symbol) {
        if(row>=0 && col>=0 && row<size && col<size && grid[row][col].getSymbol()==null){
            grid[row][col].setValue(symbol);
            return true;
        }
        System.out.println("Invalid move please try again");
        return false;
    }


    public boolean checkForDraw() {
        for(int i = 0 ; i < size;i++){
            for(int j = 0 ; j < size;j++){
                if(grid[i][j]==null){
                    return true;
                }
            }
        }
        return false;
}

    public boolean checkWin(Symbol symbol) {
        // rows and columns
        for (int i = 0; i < size; i++) {
            boolean rowWin = true, colWin = true;
            for (int j = 0; j < size; j++) {
                if (grid[i][j].getSymbol() != symbol) rowWin = false;
                if (grid[j][i].getSymbol() != symbol) colWin = false;
            }
            if (rowWin || colWin) return true;
        }

        // diagonals
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i].getSymbol() != symbol) diag1 = false;
            if (grid[i][size - i - 1].getSymbol() != symbol) diag2 = false;
        }
        return diag1 || diag2;
    }
}

package MachineCoding.TicTacToe1;

import Symbol;

public class Board {

    int size;
    Cell [][]grid;



    public Board(int size){
        this.size = size;
        this.grid = new Cell[size][size];
        for(int i = 0 ; i <size;i++){
            for(int j = 0 ; j<size;j++){
                grid[i][j] = new Cell(i,j);
            }

        }
    }

    public boolean placeSymbol(int row, int column, Player currPlayer) {

        if(row>=0 && column>=0 && row<size && column<size && grid[row][column].getSymbol()==null){
            grid[row][column].setSymbol(currPlayer.getSymbol());
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for(int i = 0 ; i <size;i++){
            for(int j = 0 ; j<size;j++){
                if(grid[i][j].getSymbol()==null)return false;
            }
        }
        return true;
    }

    public void printBoard() {
        for(int i = 0 ; i <size;i++){
            for(int j = 0 ; j<size;j++){
                if(grid[i][j].getSymbol()!=null){
                    System.out.println(grid[i][j].getSymbol()+" ");

                }else{
                    System.out.println("-");
                }
            }
            System.out.println();

        }
    }

    public boolean checkWin(Symbol symbol) {
        // rows and columns
        for (int i = 0; i < size; i++) {
            boolean rowWin = true, colWin = true;
            for (int j = 0; j < size; j++) {
                if (grid[i][j].getSymbol().equals(symbol)) rowWin = false;
                if (grid[j][i].getSymbol().equals(symbol)) colWin = false;
            }
            if (rowWin || colWin) return true;
        }

        // diagonals
        boolean diag1 = true, diag2 = true;
        for (int i = 0; i < size; i++) {
            if (grid[i][i].getSymbol().equals(symbol)) diag1 = false;
            if (grid[i][size - i - 1].getSymbol().equals(symbol)) diag2 = false;
        }
        return diag1 || diag2;
    }

}

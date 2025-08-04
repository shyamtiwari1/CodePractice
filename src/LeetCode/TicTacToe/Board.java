package LeetCode.TicTacToe;

public class Board {
    private int size;
    private Cell[][] grid;

    public Board(int size) {
        this.size = size;
        this.grid = new Cell[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                grid[i][j] = new Cell(i, j);
    }

    public boolean placeSymbol(int row, int col, Symbol symbol) {
        if (row < 0 || row >= size || col < 0 || col >= size || !grid[row][col].isEmpty()) {
            return false;
        }
        grid[row][col].setSymbol(symbol);
        return true;
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

    public boolean isFull() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                if (grid[i][j].isEmpty()) return false;
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Symbol s = grid[i][j].getSymbol();
                System.out.print((s != null ? s : "_") + " ");
            }
            System.out.println();
        }
    }
}



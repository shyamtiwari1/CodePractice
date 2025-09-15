package MachineCoding;

import java.util.*;

public class TicTacToe1 {

    /** Core domain: Player */
    static class Player {
        private final String name;
        private final char symbol; // e.g., 'X', 'O', 'A', 'B'...

        public Player(String name, char symbol) {
            this.name = name;
            this.symbol = symbol;
        }
        public String getName() { return name; }
        public char getSymbol() { return symbol; }
    }

    /** Board that supports NxN and K-in-a-row checks */
    static class Board {
        private final int n;
        private final char[][] grid;
        private final int winLen;
        private static final char EMPTY = '-';

        public Board(int n, int winLen) {
            if (n < 3) throw new IllegalArgumentException("Board size must be >= 3");
            if (winLen < 3 || winLen > n) throw new IllegalArgumentException("winLen must be in [3, n]");
            this.n = n;
            this.winLen = winLen;
            this.grid = new char[n][n];
            for (int i = 0; i < n; i++) Arrays.fill(grid[i], EMPTY);
        }

        public int size() { return n; }
        public int winLength() { return winLen; }
        public boolean isFull() {
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (grid[i][j] == EMPTY) return false;
            return true;
        }
        public boolean isEmptyCell(int r, int c) {
            return inBounds(r,c) && grid[r][c] == EMPTY;
        }
        public boolean inBounds(int r, int c) {
            return r >= 0 && r < n && c >= 0 && c < n;
        }
        public boolean place(int r, int c, char sym) {
            if (!inBounds(r,c) || grid[r][c] != EMPTY) return false;
            grid[r][c] = sym;
            return true;
        }
        public void print() {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(grid[i][j]);
                    if (j < n - 1) System.out.print(' ');
                }
                System.out.println();
            }
        }

        /** Check winner by scanning 4 directions from the last move. O(K). */
        public boolean isWinningMove(int row, int col, char sym) {
            // Directions: (dr,dc) pairs; we count both +dir and -dir for each axis
            int[][] dirs = new int[][]{
                    {0,1},  // horizontal
                    {1,0},  // vertical
                    {1,1},  // main diagonal
                    {1,-1}  // anti-diagonal
            };
            for (int[] d : dirs) {
                int count = 1;
                count += countDir(row, col, d[0], d[1], sym);
                count += countDir(row, col, -d[0], -d[1], sym);
                if (count >= winLen) return true;
            }
            return false;
        }

        private int countDir(int r, int c, int dr, int dc, char sym) {
            int cnt = 0;
            int i = r + dr, j = c + dc;
            while (inBounds(i,j) && grid[i][j] == sym) {
                cnt++;
                i += dr; j += dc;
            }
            return cnt;
        }
    }

    /** Game engine: supports M players, turn-rotation, NxN board, K-in-a-row */
    static class TicTacToe {
        private final Board board;
        private final List<Player> players;
        private int turnIdx = 0; // index in players for current turn

        public TicTacToe(int n, int winLen, List<Player> players) {
            if (players == null || players.size() < 2)
                throw new IllegalArgumentException("Need at least 2 players");
            this.board = new Board(n, winLen);
            validateSymbols(players);
            this.players = new ArrayList<>(players);
        }

        private void validateSymbols(List<Player> players) {
            Set<Character> seen = new HashSet<>();
            for (Player p : players) {
                char s = p.getSymbol();
                if (s == '-') throw new IllegalArgumentException("'-' reserved as empty cell");
                if (!seen.add(s))
                    throw new IllegalArgumentException("Duplicate player symbol: " + s);
            }
        }

        public Player currentPlayer() { return players.get(turnIdx); }
        private void nextTurn() { turnIdx = (turnIdx + 1) % players.size(); }

        /** Make a move; returns winner name on win, "DRAW" on draw, or null to continue. */
        public String move(int row, int col) {
            Player p = currentPlayer();
            boolean placed = board.place(row, col, p.getSymbol());
            if (!placed) throw new IllegalArgumentException("Invalid move at (" + row + "," + col + ")");
            if (board.isWinningMove(row, col, p.getSymbol())) return p.getName();
            if (board.isFull()) return "DRAW";
            nextTurn();
            return null;
        }

        public void printBoard() { board.print(); }
        public int size() { return board.size(); }
        public int winLength() { return board.winLength(); }
    }

    /** Simple CLI demo (optional). Replace input source as needed. */
    public class Main {
        public static void main(String[] args) {
            // Example: 4x4 board, need 3-in-a-row, 3 players
            List<Player> players = Arrays.asList(
                    new Player("Alice", 'X'),
                    new Player("Bob",   'O'),
                    new Player("Cara",  'A')
            );
            TicTacToe game = new TicTacToe(4, 3, players);

            System.out.println("Board " + game.size() + "x" + game.size() + ", winLen=" + game.winLength());
            System.out.println("Players (turn order): Alice[X], Bob[O], Cara[A]");
            System.out.println("Enter moves as: row col (0-indexed)");

            Scanner sc = new Scanner(System.in);
            String result = null;
            while (result == null) {
                game.printBoard();
                Player cp = game.currentPlayer();
                System.out.print(cp.getName() + " [" + cp.getSymbol() + "] move: ");
                int r = sc.nextInt(), c = sc.nextInt();
                try {
                    result = game.move(r, c);
                } catch (IllegalArgumentException ex) {
                    System.out.println("Invalid: " + ex.getMessage());
                }
            }
            game.printBoard();
            if ("DRAW".equals(result)) System.out.println("Result: Draw!");
            else System.out.println("Winner: " + result);
        }
    }

}

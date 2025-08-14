package Code.LeetCode.TicTacToe;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player[] players;
    private int currentPlayer;

    public Game(Player p1, Player p2, int boardSize) {
        this.board = new Board(boardSize);
        this.players = new Player[]{p1, p2};
        this.currentPlayer = 0;
    }

    public Game(Player p1, Player p2, Player p3, int boardSize) {
        this.board = new Board(boardSize);
        this.players = new Player[]{p1, p2 , p3};
        this.currentPlayer = 0;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.printBoard();
            Player player = players[currentPlayer];
            System.out.println(player.getName() + "'s turn (" + player.getSymbol() + "). Enter row and column:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (!board.placeSymbol(row, col, player.getSymbol())) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            if (board.checkWin(player.getSymbol())) {
                board.printBoard();
                System.out.println(player.getName() + " wins!");
                break;
            }

            if (board.isFull()) {
                board.printBoard();
                System.out.println("Game is a draw!");
                break;
            }

            currentPlayer = 1 - currentPlayer;
        }

        scanner.close();
    }
}




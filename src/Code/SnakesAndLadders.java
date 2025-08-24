package Code;

import java.util.*;

public class SnakesAndLadders {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int square = curr[0];
            int moves = curr[1];

            if (square == n * n) return moves;

            for (int i = 1; i <= 6; i++) {
                int nextSquare = square + i;
                if (nextSquare > n * n) break;

                int[] rc = getCoordinates(nextSquare, n);
                int r = rc[0], c = rc[1];

                if (board[r][c] != -1) {
                    nextSquare = board[r][c]; // move to snake/ladder destination
                }

                if (!visited[nextSquare]) {
                    visited[nextSquare] = true;
                    queue.offer(new int[]{nextSquare, moves + 1});
                }
            }
        }

        return -1; // unreachable
    }

    // Helper to convert square number to (row, col)
    private int[] getCoordinates(int square, int n) {
        int r = n - 1 - (square - 1) / n;
        int c = (square - 1) % n;
        if ((n - 1 - r) % 2 == 1) {
            c = n - 1 - c; // reverse column for boustrophedon
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        int[][] board = {
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };
        SnakesAndLadders sol = new SnakesAndLadders();
        System.out.println(sol.snakesAndLadders(board)); // Output: minimum moves
    }
}


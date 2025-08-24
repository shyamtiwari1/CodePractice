package Code.LeetCode.graph;

import java.util.*;

public class VirusSpread {
    static class Cell {
        int row, col, time;
        Cell(int r, int c, int t) {
            row = r; col = c; time = t;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] grid = new int[N][M];
        Queue<Cell> queue = new LinkedList<>();
        int healthy = 0;

        // Read grid and initialize BFS queue with infected cells
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 2) {
                    queue.offer(new Cell(i, j, 0)); // infected cells
                }
                if(grid[i][j] == 1) healthy++; // count healthy cells
            }
        }

        int[] dR = {-1, 1, 0, 0}, dC = {0, 0, -1, 1};
        int time = 0, infected = 0;

        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            time = cell.time;
            for(int k = 0; k < 4; k++) {
                int nr = cell.row + dR[k], nc = cell.col + dC[k];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    infected++;
                    queue.offer(new Cell(nr, nc, cell.time + 1));
                }
            }
        }

        // Output result
        if(healthy == 0) System.out.println(0);
        else if(infected == healthy) System.out.println(time);
        else System.out.println(-1);
    }
}


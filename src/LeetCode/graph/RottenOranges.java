package LeetCode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RottenOranges {

//    https://leetcode.com/problems/rotting-oranges/description/

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();
        int [][] visited = new int[n][m];
        int cntFresh = 0 ;
        for(int i = 0 ; i < n ; i ++){
            for(int j = 0 ; j < m ; j ++){
                if(grid[i][j]==2){
                    queue.add(new Pair(i , j , 0));
                    visited[i][j]= 2;
                }else{
                    visited[i][j] = 0 ;
                }
                if(grid[i][j]==1){
                    cntFresh++;
                }
            }
        }

        int tm = 0 ;
        int[] drow = new int[]{-1,0,1,0};
        int [] dcolumn  = new int[]{0,1,0,-1};
        int cnt = 0 ;
        while(!queue.isEmpty()){
            int r = queue.peek().row;
            int c = queue.peek().column;
            int t = queue.peek().time;
            tm = Math.max(tm , t);
            queue.remove();
            for(int i = 0 ; i < 4;i++){
                int nrow = r+drow[i];
                int ncol = c+dcolumn[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    queue.add(new Pair(nrow , ncol , t+1));
                    visited[nrow][ncol] =2;
                    cnt++;

                }

            }

        }
        if(cnt != cntFresh){
            return  -1;
        }
        return tm;


    }

    public class Pair{
        int row ;
        int column ;
        int time;
        Pair(int row , int column , int time){
            this.column = column;
            this.row  = row;
            this.time = time;
        }

    }
}



package LeetCode.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NumberOfIsland {



    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];
        Queue<List<Integer>> queue = new LinkedList<>();
        int [] xcor = new int[]{1,0,-1,0};
        int [] ycor = new int[]{0,1,0,-1};
        int count = 0 ;

        for(int i = 0 ; i < n; i ++){
            for(int j = 0 ; j <m ; j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    queue.add(List.of(i,j));
                    visited[i][j] = true;
                    count++;

                    while(!queue.isEmpty()){
                        List<Integer> curr = queue.poll();
                        int x = curr.get(0);
                        int y = curr.get(1);
                        if(!visited[x][y] && grid[x][y]=='1'){
                            visited[x][y] = true;
                            for(int k = 0 ; k <4;k++){
                                int nx  =  x+xcor[k];
                                int ny  =  y+ycor[k];
                                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[nx][ny] && grid[nx][ny]=='1'){
                                    visited[nx][ny] =true;
                                    queue.add(List.of(nx,ny));
                                }

                            }
                        }
                    }
            }

            }
        }

        return count;

    }
}

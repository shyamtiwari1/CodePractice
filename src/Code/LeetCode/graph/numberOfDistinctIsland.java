package Code.LeetCode.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class numberOfDistinctIsland {


    int countDistinctIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean [][]visited = new boolean[n][m];
        int [] xcor = new int[]{1,0,-1,0};
        int [] ycor = new int[]{0,1,0,-1};
        Set<List<List<Integer>>> ans = new HashSet<>();
        for(int i = 0 ; i < n ; i ++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    List<List<Integer>> list = new ArrayList<>();
                    Queue<List<Integer>> queue = new LinkedList<>();
                    queue.add(List.of(i,j,i,j));
                    visited[i][j]=true;
                    list.add(List.of(0,0));
                    while (!queue.isEmpty()){
                        List<Integer> curr = queue.poll();
                        int currX = curr.get(0);
                        int currY = curr.get(1);
                        int baseX = curr.get(2);
                        int baseY = curr.get(3);
                        for(int l = 0 ; l <4;l++){
                            int newX=currX+xcor[l];
                            int newY = currY+ycor[l];
                            if(newX>=0 && newY>=0 && newX<n && newY<m && !visited[newX][newY] && grid[newX][newY]==1){
                                visited[newX][newY] = true;
                                queue.add(List.of(newX,newY,baseX,baseY));
                                list.add(List.of(newX-baseX , newY-baseY));
                            }
                        }

                    }
                    ans.add(list);
                }

            }
        }
return ans.size();

    }
}

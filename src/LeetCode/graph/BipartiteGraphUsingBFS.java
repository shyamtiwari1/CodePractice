package LeetCode.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraphUsingBFS {

    public static void main(String args[]){
        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph2 = new int[][]{{1,3},{0,2},{1,3},{0,2}};
        System.out.println(isBipartite(graph));
        System.out.println(isBipartite(graph2));

    }



    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        Queue<Integer> queue = new LinkedList<>();
        int [] color = new int[n];
        Arrays.fill(color , -1);
        for(int i = 0 ; i < n ; i ++){
            if(color[i]==-1){
                queue.add(i);
                color[i] =1;
                while(!queue.isEmpty()){
                    int curr = queue.poll();
                    for(int j : graph[curr]){
                        if(color[j]==-1){
                            color[j] = 1-color[curr];
                            queue.add(j);
                        } else if (color[j]==color[curr]) {
                            return false;

                        }
                    }
                }
            }
        }
        return true;

    }
}

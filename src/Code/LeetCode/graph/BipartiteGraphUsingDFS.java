package Code.LeetCode.graph;

import java.util.Arrays;

public class BipartiteGraphUsingDFS {

    public static void main(String[]args){
        int[][] graph = new int[][]{{1,2,3},{0,2},{0,1,3},{0,2}};
        int[][] graph2 = new int[][]{{1,3},{0,2},{1,3},{0,2}};

        System.out.println(isBipartite(graph));
        System.out.println(isBipartite(graph2));




    }



    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[]color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0 ; i < n;i++){
            if(color[i]==-1){
                color[i]=0;
                if(! dfs(graph , color , i))return false;
            }
        }

        return true;


    }

    public static boolean dfs(int[][] graph , int[]color , int baseNode) {
            for(int i : graph[baseNode]){
                if(color[i]==-1){
                    color[i] = 1-color[baseNode];
                    if(!dfs(graph , color , i)){
                        return false;
                    }
                } else if (color[i]==color[baseNode]) {
                    return false;

                }

            }

        return true;

    }
}

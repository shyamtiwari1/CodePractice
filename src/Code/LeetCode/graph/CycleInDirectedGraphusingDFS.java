package Code.LeetCode.graph;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraphusingDFS {

    //if you want to use a BFS approach  - -- >check using toposort , if it has exactly n elements it is a DAG hence no cycle , else it has a cycle

    public boolean isCyclic(int V, int[][] edges) {

        int n = edges.length;

        List<List<Integer>> adjecencyList = new ArrayList<>();
        for(int i = 0 ; i < V ; i ++){
            adjecencyList.add(new ArrayList<>());
        }
        for(int [] edge: edges){
            adjecencyList.get(edge[0]).add(edge[1]);
        }
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        for(int i = 0 ; i < n ; i ++){
            if(visited[i]==0){
                 if(dfsCheck(edges, i, visited, pathVisited))return true;
            }
        }
        return false;
    }

    private boolean dfsCheck(int[][] edges, int i, int[] visited, int[] pathVisited) {
        visited[i]=1;
        pathVisited[i]=1;
        for(int j: edges[i]){
            if(visited[j]==0){
                if(dfsCheck(edges , j , visited , pathVisited))return true;
            } else if (pathVisited[j]==1) {
                return true;

            }
        }
        pathVisited[i]=0;
        return false;


    }
}

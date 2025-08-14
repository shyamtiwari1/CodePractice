package Code.LeetCode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class shortestPathInDAG {



    public int[] shortestPath(int n , int m , int[][] edges){
        List<List<List<Integer>>> adjList = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++){
            adjList.add(new ArrayList<>());
        }
        for(int i = 0 ; i <m ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adjList.get(u).add(List.of(v, wt));
        }
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for(int j = 0 ; j < n ; j++){
            if(visited[j]!=1){
                toposort(j , visited , stack , adjList);
            }
        }

        int[] dist = new int[n];
        for(int i= 0 ; i<n ; i ++ ){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[0]=0;
        while(!stack.isEmpty()){
            int curr = stack.pop();
            for(List<Integer> it : adjList.get(curr)){
                int wt = dist[curr];
                if(wt+dist[it.get(0)]<it.get(1)){
                    dist[it.get(0)]=wt+dist[it.get(0)];
                }
            }
        }
        return dist;

    }

    private void toposort(int j, int[] visited, Stack<Integer> stack, List<List<List<Integer>>> adjList) {

        visited[j]=1;
        for(List<Integer> it: adjList.get(j)){
            int v = it.get(0);
            if(visited[v]!=1){
                toposort(v, visited , stack , adjList);
            }

        }
        stack.push(j);
    }
}

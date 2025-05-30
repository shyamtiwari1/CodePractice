package LeetCode.graph;

import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {

    //only applicable in DAG(Directed acyclic graqph)

    public int[] topoSortDfs(List<List<Integer>> adjList , int v ){
        int[] visited = new int[v];
        Stack<Integer> stack = new Stack<>(); 
        for(int i = 0 ; i <v ; i ++){
            if(visited[i]!=1){
                dfsTopo(i , visited , adjList,stack);
            }
        }
        int[] ans = new int[v];
        for(int q=0 ; q<v;q++){
            ans[q] = stack.pop();
        }
        return ans;

    }

    private void dfsTopo(int i, int[] visited, List<List<Integer>> adjList, Stack<Integer> stack) {
        visited[i] = 1;
        for(int it: adjList.get(i)){
            if(visited[it]==0){
                dfsTopo(it, visited , adjList , stack);
            }
        }
        stack.push(i);
    }


}

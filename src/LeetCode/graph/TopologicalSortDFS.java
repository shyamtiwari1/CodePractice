package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;



public class TopologicalSortDFS {

    public static void main(String args[]) {
        // Example:
        // Graph:
        // 0 -> 1
        // 0 -> 2
        // 1 -> 3
        // 2 -> 3
        int v = 4;
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(0).add(1);
        adjList.get(0).add(2);
        adjList.get(1).add(3);
        adjList.get(2).add(3);

        int[] result = topoSort(v, adjList);

        System.out.println("Topological Sort:");
        System.out.println(Arrays.toString(result));
    }

    public static int[] topoSort(int v , List<List<Integer>>adjList){
        int [] visited = new int[v];
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <v ; i ++){
            if(visited[i]!=1){
                dfs(i , visited , stack , adjList);
            }
        }
        int[] ans = new int[v];
        for(int i = 0 ; i <v ; i ++){
            ans[i] = stack.pop();
        }
        return ans;

    }

    private static void dfs(int i, int[] visited, Stack<Integer> stack, List<List<Integer>> adjList) {
        visited[i] =1;
        for(int l : adjList.get(i)){
            if(visited[l]!=1){
                dfs(l,visited,stack,adjList);
            }
        }
        stack.add(i);
    }




    public static int[] topologicalSort(int n , List<List<Integer>>adjlist){

        int []vis = new int[n];
        Arrays.fill(vis,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i <n ; i ++){
            if(vis[i]==-1){
                dfsToposort(i , vis , stack , adjlist);
            }
        }
        int[] ans = new int[stack.size()];
        for(int i = 0 ; i <n ; i ++){
            ans[i] = stack.pop();
        }
        return ans;
    }

    private static void dfsToposort(int i, int[] vis, Stack<Integer> stack, List<List<Integer>> adjlist) {
        vis[i] = 1;
        for(int j : adjlist.get(i)){
            if(vis[j]==-1){
                dfsToposort(j , vis , stack , adjlist);
            }
        }
        stack.push(i);
    }
}

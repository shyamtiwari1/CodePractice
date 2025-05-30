package LeetCode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class dfs {
    public static void main(String args[]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        int src = 0;
        boolean [] visited = new boolean[adj.size()];
        List<Integer> ans = new ArrayList<>();
        List<Integer> ans1 = dfsTraversal(adj, src , visited , ans);
        for (int i : ans1) {
            System.out.print(i + " ");
        }


    }


    public static List<Integer> dfsTraversal(ArrayList<ArrayList<Integer>> adjecencyList, int baseNode , boolean [] visited , List<Integer> ans){
        visited[baseNode] = true;
        ans.add(baseNode);
        for(int i : adjecencyList.get(baseNode)){
            if(visited[i] != true){
                dfsTraversal(adjecencyList , i , visited , ans);
            }
        }
        return ans;

    }

    public static List<Integer> dfsTraversal1(ArrayList<ArrayList<Integer>> adjecencyList , int baseNode , boolean[] visited , List<Integer> ans){
        visited[baseNode]  = true;
        ans.add(baseNode);
        for(int i : adjecencyList.get(baseNode)){
            if(!visited[i]){
                dfsTraversal1(adjecencyList , i , visited , ans);
            }
        }
        return ans;
    }
}

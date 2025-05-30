package LeetCode.graph;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgoTopologicalSortBFS {



    public int[] topoSort(int V , List<List<Integer>>adjecencyList){

        int[] inDegree = new int[V];
        for(int i = 0 ; i < V ; i ++){
            for(int j : adjecencyList.get(i)){
                inDegree[j] = inDegree[j]+1;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i= 0 ; i < inDegree.length ; i ++){
            if(inDegree[i]==0){
                queue.add(i);
            }
        }
        int[] ans = new int[V];
        int i = 0;
        while (!queue.isEmpty()){
            int curr = queue.poll();
            ans[i]=curr;
            i++;
            for(int j: adjecencyList.get(curr)){
                inDegree[j]--;
                if(inDegree[j]==0){
                    queue.add(j);
                }
            }
        }
        return ans;
    }
}

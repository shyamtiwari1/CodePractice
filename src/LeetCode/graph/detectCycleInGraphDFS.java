package LeetCode.graph;
import java.util.ArrayList;
import java.util.List;


public class detectCycleInGraphDFS {

    public static void main(String args[]){


        List<List<Integer>> graphWithCycle = new ArrayList<>();
        boolean[] visited = new boolean[4];
        for (int i = 0; i < 3; i++) graphWithCycle.add(new ArrayList<>());
        graphWithCycle.get(0).add(1);
        graphWithCycle.get(1).add(0);
        graphWithCycle.get(1).add(2);
        graphWithCycle.get(2).add(1);
        graphWithCycle.get(2).add(0);
        graphWithCycle.get(0).add(2);
        System.out.println("Cycle Present (Expected: true): " +
                detectCycleUSingDfs(graphWithCycle, 0,-1,visited));

        boolean[] visited1 = new boolean[4];
        List<List<Integer>> graphWithoutCycle = new ArrayList<>();
        for (int i = 0; i < 3; i++) graphWithoutCycle.add(new ArrayList<>());
        graphWithoutCycle.get(0).add(1);
        graphWithoutCycle.get(1).add(0);
        graphWithoutCycle.get(1).add(2);
        graphWithoutCycle.get(2).add(1);
        System.out.println("Cycle Present (Expected: false): " +
                detectCycleUSingDfs(graphWithoutCycle, 0 ,-1 ,visited1 ));

    }


    public static boolean detectCycleUSingDfs(List<List<Integer>> adjList, int baseNode, int parent, boolean[] visited){
            visited[baseNode] = true;
            for(int i : adjList.get(baseNode)){
                if(!visited[i]){
                    detectCycleUSingDfs(adjList , i ,baseNode, visited );
                }else{
                    if(i!=parent){
                        return true;
                    }
                }
            }
        return false;

    }



    public static boolean detectCycleUSingDfsagain(List<List<Integer>> adjList, int baseNode, int parent, boolean[] visited){
        visited[baseNode] = true;
        for(int i : adjList.get(baseNode)){
            if(visited[i] &&  i != parent){
                return true;
            }
            if(!visited[i]){
                visited[i] = true;
                detectCycleUSingDfsagain(adjList , i ,baseNode , visited );
            }
        }
        return false;

    }
}

package LeetCode.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AliendictonaryBFS {




    public static String findOrder(String[] words , int k ) {
        List<List<Integer>>adj = new ArrayList<>();
        for(int i = 0 ; i <k ;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < words.length-1 ; i++){
            String w1 =  words[i];
            String w2 =  words[i+1];
            int n = Math.min(w1.length(),w2.length());
            int j = 0 ;
            while (j<n && w1.charAt(j)==w2.charAt(j)){
                j++;
            }
            adj.get(w1.charAt(j)-'a').add(w2.charAt(j)-'a');
        }
        Stack<Integer> stack = new Stack<>();
         boolean[] visited = new boolean[k];
         for(int x = 0 ; x<k ;x++){
             if(visited[x]==false){
                 toposort(adj , stack ,x ,visited);
             }
         }
        StringBuilder sb = new StringBuilder();
        for(int it: stack){
            sb.append((char)(it + 'a'));
        }
        return sb.toString();




    }


    public static void toposort(List<List<Integer>>adj , Stack<Integer> stack , int n , boolean[] visited  ) {
        visited[n] = true;
        for(int i: adj.get(n)){
            if(!visited[i]){
                toposort(adj , stack , i , visited);
            }
        }
        stack.push(n);
    }
}

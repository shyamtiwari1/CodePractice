package Code.LeetCode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class islandInGraphUsingBfs {





    public static void main(String args[]){

    }


    public static void bfs(char[][] M , boolean[][] visited , int sr , int sc){

        int [] rNbr = {-1 , -1 , -1, 0 ,0 , 1 , 1, 1 };
        int [] cNbr = {-1 , 0 , 1, -1 ,1 , -1 , 0, 1 };

//        (1, 1)(1,0)(0,1)(-1,-1)(-1,0)(-1,1)()()
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        visited[sr][sc] = true;
        while(!q.isEmpty()){
            int [] pos = q.poll();
            int r = pos[0];
            int c = pos[1];
            for(int k = 0 ; k < 8 ; k++){
                int newR = r+rNbr[k];
                int newC =c+cNbr[k];
                if(isSafe(M, newR , newC , visited)){
                    visited[newR][newC] = true;
                    q.add(new int[]{newR, newC});
                }
            }
        }
    }

    static boolean isSafe(char[][] M, int r, int c,
                          boolean[][] vis) {
        int rows = M.length;
        int cols = M[0].length;
        return (r >= 0) && (r < rows) && (c >= 0) &&
                (c < cols) && (M[r][c] == '1' && !vis[r][c]);
    }
}

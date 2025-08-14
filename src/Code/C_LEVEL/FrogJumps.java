package Code.C_LEVEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FrogJumps {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            String s = reader.readLine();
            int x = getMinStepsForFrog(s);
            System.out.println(x);
        }
    }

    private static int getMinStepsForFrog(String s) {
//LRLRRLL
//        length of jumps from R to next R  -> 2, 0 ,3
        /*
        *
        *
        *
        *
        * */
        int j = 0;
        int prevIndex = -1;
        int maxGap = 0;
        while(j<s.length()){
            if(s.charAt(j) =='R'){
                if(prevIndex == -1){
                    prevIndex = j;
                    maxGap = Math.max(maxGap,j+1);
            }else{
                    int gap = j-prevIndex;
                    maxGap = Math.max(maxGap,gap);
                    prevIndex = j;
                }
                }
            j++;
            }
        int finalGap = s.length()-prevIndex;
        maxGap = Math.max(maxGap,finalGap);
        return maxGap;
    }
}
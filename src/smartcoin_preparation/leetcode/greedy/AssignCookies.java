package smartcoin_preparation.leetcode.greedy;

import java.util.Arrays;

public class AssignCookies {


    public static  int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        int j = 0;
        int count = 0 ;
        // if (g[0] > s[s.length - 1])
        //     return 0;

        while (i < g.length && j < s.length) {

            if (g[i] <= s[j]) {
                i++;
                j++;
                count++;
            } else {
                while (j < s.length && g[i] > s[j]) {
                    j++;
                }
            }

        }
        return count;

    }

    public static void main(String args[]){
        int[]g =new int[]{1,2,3};
        int[]s =new int[]{1,1};


        System.out.println(findContentChildren(g,s));



    }
}

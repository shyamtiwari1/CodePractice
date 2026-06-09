package Code.LeetCode.Array;

import java.util.Arrays;

public class Candy {



//    https://leetcode.com/problems/candy/description/


    public static void main(String args[]){
        
    }



    class Solution {
        public int candy(int[] ratings) {
            int n = ratings.length;
            int[] leftarr = new int[n];
            int[] rightarr = new int[n];

            int count = 2;
            leftarr[0] = 1;
            for (int i = 1; i < n; i++) {
                if (ratings[i - 1] < ratings[i]) {
                    leftarr[i] = count;

                } else {
                    leftarr[i] = 1;
                    count = 1;
                }
                count++;
            }
            System.out.println(Arrays.toString(leftarr));
            count = 2;
            rightarr[n - 1] = 0;
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    rightarr[i] = count;

                } else {
                    rightarr[i] = 1;
                    count = 1;
                }
                count++;

            }
            System.out.println(Arrays.toString(rightarr));

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += Math.max(rightarr[i], leftarr[i]);
            }

            return ans;

        }
    }
}

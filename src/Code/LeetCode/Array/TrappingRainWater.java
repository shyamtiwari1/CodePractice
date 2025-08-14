package Code.LeetCode.Array;

public class TrappingRainWater {

//    https://leetcode.com/problems/trapping-rain-water/




    class Solution {


        /***
         * TC - O(3N)
         * SC - O(N) - not space optimised
         *
         * here we keep tract of left max and right max and calculate water over each building
         * we keep track in two arrays which can be optimised
         */



        public int trap(int[] height) {
            int n = height.length;
            int[] prefixmax = new int[n];
            int[] suffixmax = new int[n];
            int prefixmaxtillnow = height[0];
            int suffixmaxtillnow = height[n-1];
            for(int i = 0 ; i < n ; i++){
                prefixmax[i] = Math.max(height[i],prefixmaxtillnow );
                prefixmaxtillnow = prefixmax[i];
            }
            for(int i = n-1 ; i >=0 ; i--){
                suffixmax[i] = Math.max(height[i],suffixmaxtillnow );
                suffixmaxtillnow = suffixmax[i];
            }
            int totalwater = 0 ;
            for(int i = 0 ; i <n ; i++){
                if(height[i]<prefixmax[i] && height[i]<suffixmax[i]){
                    int water  = Math.min(prefixmax[i],suffixmax[i]) - height[i];
                    totalwater += water;
                }
            }
            return totalwater;

        }


        public int trapoptimised(int[] height) {
            int n = height.length;
//            int[] prefixmax = new int[n];
            int[] suffixmax = new int[n];
            int prefixmaxtillnow = height[0];
            int suffixmaxtillnow = height[n-1];
//            for(int i = 0 ; i < n ; i++){
////                prefixmax[i] = Math.max(height[i],prefixmaxtillnow );
//                prefixmaxtillnow = prefixmax[i];
//            }
            for(int i = n-1 ; i >=0 ; i--){
                suffixmax[i] = Math.max(height[i],suffixmaxtillnow );
                suffixmaxtillnow = suffixmax[i];
            }
            int totalwater = 0 ;
            for(int i = 0 ; i <n ; i++){
                prefixmaxtillnow = Math.max(prefixmaxtillnow , height[i]);
                if(height[i]<prefixmaxtillnow && height[i]<suffixmax[i]){
                    int water  = Math.min(prefixmaxtillnow,suffixmax[i]) - height[i];
                    totalwater += water;
                }
            }
            return totalwater;

        }




        public int superOptimisedTrap(int[] height) {

            /***
             * In this method we 're using two pointer
             * we move the poiunter which is small calcualte water over each building
             * this is space optimised
             */
            int l = 0 ; int n = height.length; int r= n-1;
            int totalwater = 0 ;
            int lmax = height[l] ; int rmax = height[r];
            while(l<r){
                if(height[l]<=height[r]){
                    if(lmax>height[l]){
                        totalwater+= (lmax-height[l]);
                    }else{
                        lmax = height[l];

                    }
                    l++;
                }else{
                    if(rmax>height[r]){
                        totalwater +=(rmax-height[r]);
                    }else{
                        rmax=height[r];
                    }
                    r--;

                }
            }
            return totalwater;

        }
    }
}

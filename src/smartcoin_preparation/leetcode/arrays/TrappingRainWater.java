package smartcoin_preparation.leetcode.arrays;

public class TrappingRainWater {




        public int trap(int[] height) {
            int n = height.length;

            int leftmax = height[0];
            int rightmax = height[n-1];

            int totalwater = 0 ;

            int i = 0 ; int j = n-1;

            while(i<j){
                leftmax = Math.max(leftmax,height[i]);
                rightmax = Math.max(rightmax,height[j]);

                if(height[i]>height[j]){
                    totalwater+= Math.min(leftmax, rightmax)-height[j];
                    j--;
                }else{
                    totalwater+= Math.min(leftmax, rightmax)-height[i];
                    i++;
                }
            }

            return totalwater;

        }
}

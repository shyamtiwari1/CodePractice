package LeetCode.TwoPointer;

public class containerWithMostWater {

//    https://leetcode.com/problems/container-with-most-water/description/?envType=problem-list-v2&envId=oizxjoit

    public int maxArea(int[] height) {
        int n = height.length ;
        int left = 0 ; int right =  n-1;


        int maxWater = 0;
        while(left<right){
            int currWater = (right-left)*(Math.min(height[left] , height[right]));
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
            maxWater = Math.max(currWater , maxWater);
        }

        return maxWater;


    }
}

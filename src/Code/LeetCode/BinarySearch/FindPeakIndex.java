package Code.LeetCode.BinarySearch;

public class FindPeakIndex {
//    https://leetcode.com/problems/peak-index-in-a-mountain-array/description/



    class Solution {
        public int peakIndexInMountainArray(int[] arr) {

            int i = 0 ; int j = arr.length-1;

            while(i<j){
                int mid = i+(j-i)/2;

                if(arr[mid]>arr[mid+1]){
                    j = mid;
                }else{
                    i = mid+1;
                }
            }
            return j;

        }
    }
}

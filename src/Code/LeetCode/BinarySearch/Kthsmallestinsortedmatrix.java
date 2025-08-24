package Code.LeetCode.BinarySearch;

public class Kthsmallestinsortedmatrix {
//    https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/



// here , we get the rane of elemets in the matrix , for each mid we check if number of elemts smalleer than mid are less or more tha k
//    if less we move end to mid , if less we move start to mid +1


    class Solution {
        public int kthSmallest(int[][] matrix, int k) {

            int n = matrix[0].length;
            int start = matrix[0][0];
            int end = matrix[n-1][n-1];

            while(start<end){
                int mid = start+(end-start)/2;
                int countlessorequal = countlessorequal(matrix, mid , n);

                if(countlessorequal>=k){
                    end = mid;
                }else{
                    start = mid+1;
                }
            }
            return start;

        }

        public int countlessorequal(int[][] matrix , int target , int n ){
            int row = n-1;
            int col = 0 ;
            int count = 0 ;
            while(row>=0 && col<n){
                if(matrix[row][col]<=target){
                    count+=row+1;
                    col++;
                }else{
                    row--;
                }
            }
            return count;
        }
    }
}

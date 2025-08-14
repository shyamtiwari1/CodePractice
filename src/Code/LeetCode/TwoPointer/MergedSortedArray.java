package Code.LeetCode.TwoPointer;

public class MergedSortedArray {
//    https://leetcode.com/problems/merge-sorted-array/description/
    public static void main(String args[]){
        int nums1[] = {1,2,3, 0 , 0 , 0 };
        int m = 3;
        int nums2[] = {2,5,6};
        int n = 3;
        merge2(nums1 , 3, nums2 , 3);

    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0 ;
        int j = 0 ;
        int[] res = new int[n+m];
        int currIndex = 0;
        while(i< m && j < n ){
            if(nums1[i]<=nums2[j]){
                res[currIndex] = nums1[i];
                if(i==m-1){
                    while(j<n){
                        res[currIndex] = nums2[j];
                        currIndex++;
                        j++;
                    }
                }
                currIndex++;
                i++;
            } else {
                res[currIndex] = nums2[j];
                if (j == n - 1) {
                    while (i < m) {
                        res[currIndex] = nums2[j];
                        currIndex++;
                        i++;
                    }
                }
                currIndex++;
                j++;
            }

        }
        for(int l = 0 ; l<m+n ; l++){
            System.out.println(res[l]);
        }

    }



    public static void merge2(int[] nums1, int m, int[] nums2, int n) {

        int i = m-1;
        int j = n-1;
        int currIndex = m+n-1;
        while(i>=0 && j>=0 ){
            if(nums1[i]>=nums2[j]){
                nums1[currIndex] = nums1[i];
                i--;
            }else{
                nums1[currIndex] = nums2[j];
                j--;
            }
            currIndex--;

        }
        //here we're stopring the nums2 elemnt if remianinhg any
        while (j >= 0) {
            nums1[currIndex] = nums2[j];
            currIndex--;
            j--;
        }

    }

}

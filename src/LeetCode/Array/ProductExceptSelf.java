package LeetCode.Array;

public class ProductExceptSelf {

    public static void main(String args[]){
        int[] arr = new int[]{1,2,3,4};
        System.out.println(productExceptSelf(arr));
    }



        public static int[] productExceptSelf(int[] nums) {
            int prefix = 1;
            int n = nums.length;
            int[] res  = new int[n];
            for(int i = 0 ; i < n ; i++){
                res[i]=prefix;
                prefix*=nums[i];
            }
            int suffix = 1;
            for (int i = n - 1; i >= 0; i--) {
                res[i] *= suffix;
                suffix *= nums[i];
            }
            return res;

        }

}

package LeetCode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopKFrequentElement {

    public static void main(String args[]){

        int []nums = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] ans = topKFrequent(nums,k);
        for(int i = 0 ; i < ans.length;i++){
            System.out.println(ans[i]);
        }

    }





    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> pq = new HashMap<>();
        for(int i = 0 ; i < nums.length;i++){
            int val =  pq.getOrDefault(nums[i] , 0);
            pq.put(nums[i] , val+1);
        }
        int[][] arr = new int[pq.size()][2];
        int j = 0 ;
        for(int i : pq.keySet()){
            arr[j][0] = i;
            arr[j][1] = pq.get(i);
            j++;
        }
        Arrays.sort(arr , (a, b)-> Integer.compare(a[1],b[1]));
        int[] ans = new int[k];

        while(k>=1){
            ans[k-1] = arr[k][0];
            k--;
        }

        return ans;




    }
}

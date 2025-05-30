package LeetCode.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class FruitsIntoBasket {

    public static void main (String args[]){
        int[] fruits = new int[]{1,2,3,2,2};
        System.out.println(totalFruit(fruits , 2));

    }



    public static int totalFruit(int[] fruits , int k ) {
        Map<Integer , Integer> mpp = new HashMap<>();

        int i = 0 ;
        int j = 0 ;
        int n = fruits.length;
        int ans = 0 ;

        while(j<n){
            mpp.put(fruits[j] , mpp.getOrDefault(fruits[j] , 0)+1);
            if(mpp.size()>k){
                while(mpp.size()!=k){
                    mpp.put(fruits[i] , mpp.get(fruits[i])-1);
                    if(mpp.getOrDefault(fruits[i],0)==0){
                        mpp.remove(fruits[i]);
                    }
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}

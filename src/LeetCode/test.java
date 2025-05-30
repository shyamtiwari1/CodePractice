package LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {

    public static void main(String args[]){
        String s = "abcabcbb";
        int [] nums = new int[]{9,8,1,0,1,9,4,0,4,1};
        int k=2;
        System.out.println(maxWidthRamp(nums));

    }

    public static int maxWidthRamp(int[] nums) {
        List<Integer> indexList = getIndexList(nums);
        int n = nums.length;
        int maxDiff = 0 ;
        int minTillNow = Integer.MAX_VALUE;
        int i = 0 ; int j = 0 ;
        while(j<n){
            if(indexList.get(j)< minTillNow){
                minTillNow = indexList.get(j);
                i=j;
            }
            maxDiff = Math.max(maxDiff , indexList.get(j)-indexList.get(i));
            j++;

        }
        return maxDiff;

    }

    public static  List<Integer> getIndexList(int[] nums){
        List<List<Integer>> newList = new ArrayList<>();
        List<Integer> indexList = new ArrayList<>();

        for(int i = 0 ; i < nums.length; i ++){
            newList.add(List.of(nums[i] , i));
        }
        newList.sort((a,b)->Integer.compare(a.get(0) , b.get(0)));
        for(int i = 0 ; i <nums.length;i++){
            indexList.add(newList.get(i).get(1));
        }
        return indexList;
    }

    }

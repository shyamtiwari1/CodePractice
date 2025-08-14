package Code.LeetCode.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrayTwo {

//    https://leetcode.com/problems/intersection-of-two-arrays-ii/description/
    public static  void  main(String args[]){
        int[] nums1 = {9,4,9,8,4};
        int[] nums2 = {4,9,5};
        int[] res = intersection1(nums1 , nums2);
        for(int i = 0 ; i< res.length ; i++){
            System.out.println(res[i]);
        }

    }




    public static int[] intersection1(int[] nums1, int[] nums2) {
        Map<Integer , Integer> map1 = new HashMap<>();
        for(int i = 0 ; i<nums1.length ; i++){
            if(map1.containsKey(nums1[i])){
                map1.put(nums1[i] , map1.get(nums1[i])+1);
            }else{
                map1.put(nums1[i] ,1);
            }
        }
        Map<Integer , Integer> map2 = new HashMap<>();
        for(int i = 0 ; i<nums2.length ; i++){
            if(map2.containsKey(nums2[i])){
                map2.put(nums2[i] , map2.get(nums2[i])+1);
            }else{
                map2.put(nums2[i] ,1);
            }
        }
        List<Integer> list = new ArrayList<>();
        for(Integer  key : map1.keySet()){
            if(map2.containsKey(key)){
                int countOfKey = Math.min(map1.get(key) , map2.get(key));
                    int j = 0 ;
                    while(j<countOfKey){
                        list.add(key);
                        j++;
                    }
            }
        }
        int res[] = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            res[i] = list.get(i);
        }
        return  res;
    }
}

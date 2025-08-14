package Code.LeetCode.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class IntersectionOfTwoArrays {

//    https://leetcode.com/problems/intersection-of-two-arrays/
    public static void main(String args[]){
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] res = intersection1(nums1 , nums2);
        for(int k = 0 ; k< res.length ; k++){
            System.out.println(res[k]);
        }
    }

    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for(int i = 0 ; i< nums1.length ; i++){
            if(!set1.contains(nums1[i])){
                set1.add(nums1[i]);
            }
        }
        Set<Integer> set2 = new HashSet<>();
        for(int i = 0 ; i < nums2.length ; i++){
            if(set1.contains(nums2[i])){
                set2.add( nums2[i]);
            }
        }
        int[] res = new int[set2.size()];
        int l = 0;
        for(Integer entry : set2){
            res[l] = entry;
            l++;
        }
        return res;


    }


    public static int[] intersection(int[] nums1, int[] nums2) {

        /*
        * This is the solution using binary search , but binary search is efficeient for large data sets , normal hashset can also be used
        *
        *
        * */
        int l1 =nums1.length;
        int l2 =nums2.length;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res = new ArrayList<>();
        if(l1 >l2 ){
            for(int i = 0 ; i< l2 ; i++){
                if(BinarySearchIterative(nums1, nums2[i]) != -1){
                    res.add(nums2[i]);
                }
            }
        }else {
            for(int i = 0 ; i< l1 ; i++){
                if(BinarySearchIterative(nums2 , nums1[i]) !=-1){
                    res.add(nums1[i]);
                }
            }
        }
        Set<Integer> resultSet = new HashSet<>(res);
        int[] result = new int[resultSet.size()];
        int i = 0 ;
        for(Integer enrty : resultSet){
            result[i] = enrty;
            i++;
        }


        return result;


    }

    public static int BinarySearchIterative(int[] arr , int a){
        int lowerBound = 0;
        int upperBound = arr.length-1;
        while(lowerBound<=upperBound){
            int mid = (lowerBound+upperBound)/2;
            if(arr[mid]==a){
                return mid;
            }else if (arr[mid]>a){
                upperBound = mid-1;
            }else{
                lowerBound = mid+1;
            }
        }
        return -1;
    }
}

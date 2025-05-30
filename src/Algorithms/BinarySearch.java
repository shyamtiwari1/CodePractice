package Algorithms;

import java.util.List;
//[1 ,2 3 4, 5] 2
public class BinarySearch {
    public static void main(String args[]){
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> arr = List.of(12,25,39,42,55 , 70 , 100 , 120);
        int a = 70;
        int index = binarySearch.binarySearchRecursive (arr , a , 0 , arr.size()-1);
        System.out.println(index);
    }
    public int BinarySearchIterative(List<Integer> arr , int a){
        int lowerBound = 0;
        int upperBound = arr.size()-1;
        while(lowerBound<=upperBound){
            int mid = (lowerBound+upperBound)/2;
            if(arr.get(mid)==a){
                return mid;
            }else if (arr.get(mid)>a){
                upperBound = mid-1;
            }else{
                lowerBound = mid+1;
            }
        }
        return -1;
    }
    public int binarySearchRecursive(List<Integer> arr , int a , int lowerBound , int upperBound){
        if(lowerBound>upperBound){
            return -1;
        }
        int mid = (lowerBound+upperBound)/2;
        if(arr.get(mid)==a){
            return mid;
        }else if(arr.get(mid)>a){
            return binarySearchRecursive(arr , a , lowerBound , mid-1);
        }else{
            return binarySearchRecursive(arr , a , mid+1 , upperBound);
        }
    }
}

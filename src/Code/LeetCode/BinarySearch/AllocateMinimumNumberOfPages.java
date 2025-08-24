package Code.LeetCode.BinarySearch;

import java.rmi.dgc.VMID;
import java.util.Arrays;

public class AllocateMinimumNumberOfPages {

//    https://www.geeksforgeeks.org/dsa/allocate-minimum-number-pages/#expected-approach-using-binary-search


    public static void main(String [] args){
        int []arr = new int[]{12, 34, 67, 90}; int  k = 2;

        System.out.println(findPage(arr , k ));
    }


    public static  int findPage(int[] books , int k ){
        int minPage = Integer.MAX_VALUE;
        int maxpage = 0 ;

        for(int i : books){
            maxpage+=i;
            minPage=Math.min(minPage,i);
        }
        int res = -1;

        while(minPage<maxpage){
            int mid = minPage + (maxpage-minPage)/2;
            if(check(mid , books , k )){
                res = mid ;
                maxpage = mid-1;
            }else{
                minPage = mid+1;
            }


        }
        return res;
    }

    private static boolean check(int minPage, int[] books , int k ) {
        int currpages = 0 ;
        int students = 1 ;
        for(int  i : books){
            if(currpages+i>minPage){
                students++;
                currpages=i;
            }else{
                currpages+=i;
            }

        }
        return students<=k;


    }
}

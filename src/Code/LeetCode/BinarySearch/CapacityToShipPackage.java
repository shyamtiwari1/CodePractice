package Code.LeetCode.BinarySearch;

public class CapacityToShipPackage {

//    https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/



    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int n = weights.length;
            int maxcapacity = 0 ;
            int mincapacity = 0 ;
            for(int i = 0; i <n ;i++){
                maxcapacity+=weights[i];
                mincapacity = Math.max(mincapacity , weights[i]);
            }
            int ans = 0 ;

            while(mincapacity<=maxcapacity){
                int mid = mincapacity+ (maxcapacity-mincapacity)/2;
                int daysreq = getdaysreqforcap(mid,weights);
                if(daysreq>days){
                    mincapacity = mid+1;

                }else{
                    ans = mid;
                    maxcapacity = mid-1;

                }
            }
            return ans;
        }


        public int getdaysreqforcap(int mid,int[]weights){

            int currweight = 0 ;
            int days = 1;
            for(int w : weights){
                if(currweight+w>mid){
                    currweight=0;
                    days++;
                }
                currweight+=w;
            }
            return days;


        }
    }
}

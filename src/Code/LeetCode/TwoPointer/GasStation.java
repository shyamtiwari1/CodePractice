package Code.LeetCode.TwoPointer;

public class GasStation {

//    https://leetcode.com/problems/gas-station/



    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {

            int total = 0 ; int tank = 0 ;
            int i = 0 ; int j = 0 ; int n = gas.length;
            while(j<n){
                total+=gas[j]-cost[j];
                tank+=gas[j]-cost[j];

                if(tank<0){
                    tank = 0 ;
                    i = j+1;
                }
                j++;

            }

            return total>=0?i:-1;

        }
    }
}

package Code.LeetCode.BinarySearch;

public class FirstBadVersion {
//    https://leetcode.com/problems/first-bad-version/


    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public class Solution  {
        public int firstBadVersion(int n) {

            int i = 1 ;  int j = n ;
            int ans = 0;
            while(i<=j){
                int mid = i+(j-i)/2;
                if(isBadVersion(mid)){
                    ans = mid;
                    j=mid-1;
                }else{

                    i=mid+1;
                }
            }
            return ans;

        }
    }

    public boolean isBadVersion(int x){
        return true;
    }
}

package LeetCode.BianrySearch;

public class arrangingCoins {

//    https://leetcode.com/problems/arranging-coins/?envType=problem-list-v2&envId=binary-search&difficulty=EASY
    public static void main (String args[]){
        int x = arrangeCoins1(1804289383);
        System.out.println(x);
    }



    public static int arrangeCoins(int n) {
        // [1 , 2, 3, 4, 5, 6, 7......x]
//        x*(x+1)/2 = n
        int i = 0;
        int rowCount = 0 ;
        while(n>=0){
            rowCount+=1;
            i++;
            n-=i;
        }
        if(n==0){
            return rowCount;
        }
        return rowCount-1;

    }

    public static int arrangeCoins1(int n) {
        int left = 0 ;
        int right = n;
        while(left<=right){
            int mid = (left+right)/2;
            long coinUsed = ((long) mid *(mid+1))/2;
            if(coinUsed == n){
                return mid;
            }
            if(coinUsed < n){
                left = mid+1;

            }else{
                right = mid-1;

            }
        }
        return right;

    }

    public static int arrangeCoins2(int n) {
        int left = 0;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check using division to prevent overflow
            if ((long) mid * (mid + 1) / 2 == n) {
                return mid;
            }
            if ((long) mid * (mid + 1) / 2 < n) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

}

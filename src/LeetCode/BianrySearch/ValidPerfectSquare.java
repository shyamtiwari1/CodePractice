package LeetCode.BianrySearch;

public class ValidPerfectSquare {
    public static void main (String args[]){
        boolean res = isPerfectSquare(808201);
        System.out.println(res);
    }
    public static boolean isPerfectSquare(int num) {
        if (num == 1 || num == 0) {
            return true;
        }
        int start = 1;
        int end = num / 2;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid == num / mid && num % mid == 0) {
                return true;
            }
            if (mid < num / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }


    public static boolean binarySearch(int target) {
        if (target == 0 || target == 1) {
            return true;
        }

        int start = 1, end = target / 2;
        int result = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(mid == target/mid){
                return true;
            }

            if (mid < target / mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}

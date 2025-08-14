package Code.LeetCode.BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class SqrtX {
//    https://leetcode.com/problems/sqrtx/description/
    public static void main(int args[]){
        int x = 5;
        List<Integer> squares = new ArrayList<>();
        for(int i = 0 ; i<= x ; i++){
            squares.add(i);
        }
        int y = binarySearch(x );
        System.out.println(y);
    }


//[ 1,2,3,4 ]
public static int binarySearch(int target) {
    if (target == 0 || target == 1) {
        return target;
    }

    int start = 1, end = target / 2;
    int result = 0;

    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (mid <= target / mid) {
            result = mid;
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }

    return result;
}

}

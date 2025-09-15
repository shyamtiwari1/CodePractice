package Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test3 {





    public class SweetInterval {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // Read input
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int S = sc.nextInt();

            int left = 0, right = 0, sum = arr[0];
            boolean found = false;

            while (right < n) {
                if (sum == S) {
                    // Output is 1-based indexing as mentioned in the problem statement
                    System.out.println((left + 1) + " " + (right + 1));
                    found = true;
                    break;
                }
                if (sum < S) {
                    right++;
                    if (right < n) {
                        sum += arr[right];
                    }
                } else {
                    sum -= arr[left];
                    left++;
                    if (left > right && left < n) {
                        right = left;
                        sum = arr[left];
                    }
                }
            }
            Map<Integer,Integer> map = new HashMap<>();
//            map.computeIfAbsent();

            if (!found) {
                System.out.println(-1);
            }
        }
    }



}

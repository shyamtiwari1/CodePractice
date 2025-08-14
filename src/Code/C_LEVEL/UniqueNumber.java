package Code.C_LEVEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import java.util.*;

public class UniqueNumber {
//    https://codeforces.com/problemset/problem/1462/C
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int x = scanner.nextInt();

            if (x > 45) {
                result.append("-1\n");
                continue;
            }

            List<Integer> digits = new ArrayList<>();
            for (int d = 9; d > 0; d--) {
                if (x >= d) {
                    digits.add(d);
                    x -= d;
                }
            }
            Collections.sort(digits);

            for (int digit : digits) {
                result.append(digit);
            }
            result.append("\n");
        }

        // Output all results at once
        System.out.print(result);
        scanner.close();
    }
}


package CodeForces.C_LEVEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CanISquare {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());
            String[] input = reader.readLine().split(" ");
            long sum = 0;

            for (String num : input) {
                sum += Integer.parseInt(num);
            }

            double sqrt = (int) Math.sqrt(sum);
            if (sqrt * sqrt == sum) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

package Code.CodeForces.A_LEVEL;

import java.util.*;

public class Magnets {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int anu = sc.nextInt();
        int x, y = 0, z = 0;

        for (int i = 0; i < anu; i++) {
            x = sc.nextInt();
            if (x != y) z++;
            y = x;
        }

        System.out.println(z);
    }
}

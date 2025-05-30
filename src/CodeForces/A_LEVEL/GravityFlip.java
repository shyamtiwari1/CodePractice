package CodeForces.A_LEVEL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class GravityFlip {
//    https://codeforces.com/problemset/problem/405/A

    public static void main (String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String line = sc.nextLine();
        String[] numbers = line.split(" ");
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            arr.add(Integer.parseInt(numbers[i]));
        }
        Collections.sort(arr);
        for(int i = 0 ; i<n ; i++){
            System.out.print(arr.get(i) + " ");
        }

    }
}

package Code.A_LEVEL;

import java.util.Scanner;

public class GameWithSticks {
//    https://codeforces.com/problemset/problem/451/A
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int min = Math.min(n,m);
        if(min%2==0){
            System.out.println("Malvika");
        }else{
            System.out.println("Akshat");
        }
    }
}

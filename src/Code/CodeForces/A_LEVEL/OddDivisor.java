package Code.CodeForces.A_LEVEL;

import java.util.Scanner;

public class OddDivisor {
//    https://codeforces.com/problemset/problem/1475/A
    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0 ; i<n ; i++){
            long x = sc.nextLong();
            while (x%2 ==0){
                x= x/2;
            }
            if(x==1){
                System.out.println("NO");
            }else{
                System.out.println("YES");
            }

        }
    }
}

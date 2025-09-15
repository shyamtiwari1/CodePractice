package Code.CodeForces.B_LEVEL;

import java.util.Scanner;

public class MultiplyBy2DivideBy6 {
//    https://codeforces.com/problemset/problem/1374/B
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i<t ; i++){
            int n = sc.nextInt();
            func1(n);
        }
    }

    private static void func1(int n) {
        int moves = 0;
        while(n>1){
            if(n%6==0){
                n=n/6;
                moves++;
            } else if(n%3==0){
                n=n/3;
                moves+=2;
            }else{
                System.out.println(-1);
                return;
            }
        }
        System.out.println(moves);
        }
}

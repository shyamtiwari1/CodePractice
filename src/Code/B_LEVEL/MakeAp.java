package Code.B_LEVEL;

import java.util.Scanner;

public class MakeAp {
    //    https://codeforces.com/problemset/problem/1624/B
        public static void main (String args[]) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for(int i =0 ; i<t ; i++){
                int p = sc.nextInt();
                int q = sc.nextInt();
                int r = sc.nextInt();
                /* m*a , b , c; b-m*a = c-b ->2b-c = m*a -> m = (2b-c)/a -> if((2b-c)%a ==0)
                * a , m*b , c; m*b - a = c-m*b ->2m*b=c+a-> m = (c+a)/2b -> if((c+a)%2*b ==0)
                * a , b , m*c ; b-a = m*c-b -> 2b-a/c = m -> 2b-a%c ==0
                * */
                func1(p , q , r);


        }
}

    private static void func1(int a, int b, int c) {
            boolean cond1 = (2*b-c)%a ==0 && (2*b-c)/a >0;
        boolean cond2 = (c+a)%(2*b) ==0 && (c+a)/(2*b) >0;
        boolean cond3 = (2*b-a)%c ==0 && (2*b-a)/c >0;
            if( cond1|| cond2 || cond3){
                System.out.println("YES");
    }else{
                System.out.println("NO");
            }
            }
    }

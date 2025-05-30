package CodeForces.C_LEVEL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumOfCubes {
//    https://codeforces.com/problemset/problem/1490/C
//    (a+b)^3 = a^3 + b^3 + 3ab(a+b) -> a^3+b^3 = (a+b)^3 - 3ab(a+b)
    /*
    * x = 35 , -> a^3+b^3 = 35
    * a = 2 b = 3 -> 2^3 + 3^3 = 8 + 27 = 35
    * x- a^3 = b^3
    *
    *
    *
    *
    * */
            public static void main(String[] args) throws IOException {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                int t = Integer.parseInt(reader.readLine());
                for(int i = 0 ; i< t ; i++){
                    long x = Long.parseLong(reader.readLine());
                    isSumOfCubes(x);
                }
            }

    private static void isSumOfCubes(long x) {
                if(x==1){
                    System.out.println("NO");
                    return ;
                }
                for(long j = 1 ; j<=10000 ; j++){
                    long a = j*j*j;
                    long b = x - a;
                    long c = (long)Math.cbrt(b);
                    if(c*c*c == b && c>=1){
                        System.out.println("YES");
                        return ;
                    }

                }
        System.out.println("NO");
                return ;


    }
}

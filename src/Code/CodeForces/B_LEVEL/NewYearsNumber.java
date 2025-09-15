package Code.CodeForces.B_LEVEL;

import java.util.Scanner;

public class NewYearsNumber {
//    https://codeforces.com/problemset/problem/1475/B
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0 ;i<t ; i++){
            int n = scanner.nextInt();
            func1(n);
        }
    }

    private static void func1(int n) {
        int j =0;
        while(n -(j*2020)>=2021|| n -(j*2021)>=2020){
            if((n -(j*2020))%2021==0){
                System.out.println("YES");
                return;
            }
            if((n -(j*2021))%2020 ==0){
                System.out.println("YES");
                return;
            }
            j++;
        }
        System.out.println("NO");
        return;
    }
}

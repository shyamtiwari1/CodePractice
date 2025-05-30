package CodeForces.A_LEVEL;

import java.util.Scanner;

public class IlyaAndBankAccount {
//    https://codeforces.com/problemset/problem/313/A
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        maximiseBankAccountState(x);
    }

    private static void maximiseBankAccountState(int x) {
        if(x >=0){
            System.out.println(x);
            return;
        }
        if(x <0 && x >=-10){
            System.out.println(0);
            return ;
        }
        if(x <0 && x <-10){
            String s = String.valueOf(x);
            String s1 = s.substring(0 , s.length()-1);
            String s2 = s.substring(0 , s.length()-2)+s.charAt(s.length()-1);
            int a = Integer.parseInt(s1);
            int b = Integer.parseInt(s2);
            System.out.println(Math.max(a, b));
            return ;

        }
    }
}


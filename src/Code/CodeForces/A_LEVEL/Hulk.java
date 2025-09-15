package Code.CodeForces.A_LEVEL;

import java.util.Scanner;

public class Hulk {
//    https://codeforces.com/problemset/problem/705/A
    public static void main (String args[]){
        String s1  = "I hate that" ;
        String s2  = "I love that";

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String response = "I hate it";
        if(n==1){
            System.out.println(response);
            return;
        }else{
            response = "I hate that";
        }
        for(int i = 2  ; i<=n ; i++){
            if(i%2 !=0){
                response = response+ " "+s1;
            }else{
                response = response+ " "+s2;
            }
            if(i==n){
                response = response.substring(0 , response.length()-4) + " it";
            }
        }
        System.out.println(response);
    }
}

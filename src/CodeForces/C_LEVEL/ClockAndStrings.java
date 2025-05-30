package CodeForces.C_LEVEL;

import java.util.List;
import java.util.Scanner;

public class ClockAndStrings {
//    https://codeforces.com/problemset/problem/1971/C
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  t = sc.nextInt();
        for(int i = 0 ; i<t ; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            ClockAndString(a, b , c, d);
        }
}
/*
* lets say a = 2 , b = 9
* if c , d both are not in between then NO
* if both are in between -> no
* else yes
*
*11 , 12
*
* */

    private static void ClockAndString(int a, int b, int c, int d) {
        List<Integer> integerList = List.of(1 , 2, 3, 4 ,5 ,6, 7 , 8 , 9 , 10 , 11 , 12);
        int index2 = Math.max(integerList.indexOf(a) , integerList.indexOf(b));
        int index1 = Math.min(integerList.indexOf(a) , integerList.indexOf(b));;

        if(index2 !=11){
            index2++;
        }
        if(integerList.subList(index1 , index2).contains(c) && integerList.subList(index1 , index2).contains(d)){
            System.out.println("NO");
        }else if (!integerList.subList(index1 , index2).contains(c) && !integerList.subList(index1 , index2).contains(d)){
            System.out.println("NO");
        }else{
            System.out.println("YES");
        }
        }
}

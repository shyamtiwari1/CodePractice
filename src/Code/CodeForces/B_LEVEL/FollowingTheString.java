package Code.CodeForces.B_LEVEL;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//https://codeforces.com/problemset/problem/1927/B
public class FollowingTheString {

    public static void  main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0 ; i<t ; i++){
            int n = sc.nextInt();
            String s = sc.next();
            convertToString(s);
        }
    }

    private static void convertToString(String s) {
        String s1[] = s.split("");
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i<s1.length ; i++){
            if(s1[i].equals("1")){
                list.add(i);
            }
        }
    }
}

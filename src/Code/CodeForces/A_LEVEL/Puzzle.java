package Code.CodeForces.A_LEVEL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Puzzle {
//    https://codeforces.com/problemset/problem/337/A

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        String request = sc.nextLine();
        String[] numbers = request.split(" ");
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i<m ; i++){
            arr.add(Integer.parseInt(numbers[i]));
        }
        Collections.sort(arr);
        int i =0 ;
        int response = Integer.MAX_VALUE ;;
        while(n+i<=m){
            int minInt = arr.subList(i , n+i).get(0);
            int maxInt = arr.subList(i , n+i).get(n-1);
            int diff = maxInt - minInt;
            response = Math.min(diff , response);
            i++;
        }
        System.out.println(response);


    }
}

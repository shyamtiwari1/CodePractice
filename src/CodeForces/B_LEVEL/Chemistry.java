package CodeForces.B_LEVEL;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
* 6 2
    bacacd - > a , a , b , c , c , d    - > remove exactly 2 characters  nC2 = n(n-1)/2
    * (a, 2) , (b, 1) , (c, 2) , (d, 1)
    * all char has even num - true
    * all char has odd - false
    * number of chars with odd count  == k true or k+1 true else false
*
*
*
*
* */

public class Chemistry {
//    https://codeforces.com/problemset/problem/1883/B
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int  t = sc.nextInt();
        for(int i = 0 ; i<t ; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.next();
            chemistry(n, k, s);
        }
    }

    private static void chemistry(int n, int k, String s) {
        if(k == s.length() || k == s.length()-1){
            System.out.println("YES");
            return;
        }
        Map<String, Integer > countMap = new HashMap<>();
        for(int j = 0; j< n; j++){
            String c = String.valueOf(s.charAt(j));
            if(countMap.containsKey(c)){
                countMap.put(c, countMap.get(c)+1);
            }else{
                countMap.put(c, 1);
            }
        }
        int oddCount = 0;
        for(Map.Entry<String , Integer> entry : countMap.entrySet()){
            if(entry.getValue()%2!=0){
                oddCount++;
            }
        }
        if(oddCount == s.length()){
            System.out.println("NO");
            return;
        }
        if(k>=oddCount-1  || oddCount ==0  || oddCount ==1){
            System.out.println("YES");
            return ;
        }else{
            System.out.println("NO");
            return;
        }
    }
}
// -> "qrhqvaar"
// (a, 2) , (q , 2) , (r, 2) , (h, 1) , (v,1)
//aqrhvaqr
package Code.B_LEVEL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//https://codeforces.com/problemset/problem/977/B
public class TwoGram {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        List<String> twoGrams = new ArrayList<>();
        twoGrams =   getAllTwoGrams(s);
        /*
        *
        * ABACABA -> 2gram -> AB, BA, AC, CA, AB, BA
        *
        * */
//        [(AB , 2) , (BA , 2) , (AC , 1) ,(CA , 1)]
        Map<String, Integer> twoGramCount = new HashMap<>();
        for(String twoGram : twoGrams){
            if(twoGramCount.containsKey(twoGram)){
                twoGramCount.put(twoGram, twoGramCount.get(twoGram)+1);
            }else{
                twoGramCount.put(twoGram, 1);
                }
            }
        int max_count = 0;
        String response  = String.valueOf(s.charAt(0))+String.valueOf(s.charAt(1));
        for(String key : twoGramCount.keySet()){{
            if(twoGramCount.get(key) > max_count){
                max_count = twoGramCount.get(key);
                response = key;
            }
        }
        }
        System.out.println(response);

    }

    private static List<String> getAllTwoGrams(String s) {
        List<String> twoGrams = new ArrayList<>();
        for(int i = 0; i < s.length()-1; i++){
            twoGrams.add(s.substring(i, i+2));
        }
        return twoGrams;
    }
}

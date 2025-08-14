package Code.B_LEVEL;

import java.util.Scanner;


public class ZeroOneGameTwo {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            for (int i = 0; i < t; i++) {
                String s = sc.next();
                processString(s);

            }
        }

    private static void processString(String s) {
        int i = 0 ;
        int turn = 0;
        int oneCount = 0;
        int zeroCount = 0;
        while(i<s.length()){
            if(s.charAt(i) == '1'){
               oneCount++;
               i++;
            }else{
                zeroCount++;
                i++;
            }
        }
        int res = Math.min(zeroCount , oneCount);
        if(res%2 == 0){
            System.out.println("NET");
    }else{
            System.out.println("DA");
        }
        }


}

package Code.A_LEVEL;

import java.util.Scanner;

public class UltraFastMathematician {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        func1(s1,s2);



    }
    public static void func1(String s1 , String s2){
        String s3 = "";
        for(int i = 0; i< s1.length() ; i++){
            if(s1.charAt(i) == s2.charAt(i)){
                s3 = s3 + "0";
            }else{
                s3 = s3 + "1";
            }
    }
        System.out.println(s3);
    }
}

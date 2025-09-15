package Code.CodeForces.A_LEVEL;

import java.util.Scanner;

public class Dubstep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s= s.replaceAll("WUB" , " ").trim();
        System.out.println(s);
    }
}

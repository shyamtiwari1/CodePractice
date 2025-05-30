package CodeForces.A_LEVEL;

import java.util.Scanner;

public class InSearchOfEasyProblem {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0 ; i<n ; i++){
            int x = scanner.nextInt();
            if(x == 1){
                System.out.println("HARD");
                return;
            }
        }
        System.out.println("EASY");
    }
}

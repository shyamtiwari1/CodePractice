package CodeForces.A_LEVEL;

import java.util.Scanner;

public class NewYearAndHurry {
//    https://codeforces.com/problemset/problem/750/A
public static void main(String[] args) {
    /*
    * [ 1, 2, 3, 4, 5, 6 .....n]
    *[5*1 , 5*2 , 5*3 , 5*4 , 5*5 , 5*6 .....5*n]
    *
    *
    * */
    Scanner sc = new Scanner(System.in);
    int  n = sc.nextInt();
    int k = sc.nextInt();
    int time  = 0 ;
//    n [1 , 10 ] , k [1, 240]
    int totalTimeToSolveProblems = 240 -k;
    int numberOfProblemsSolved = 0;
    for(int i = 1 ; i<=n ; i++){
        if(totalTimeToSolveProblems - 5*i >= 0){
            time++;
            numberOfProblemsSolved++;
            totalTimeToSolveProblems -= 5*i;
        }else{
            break;
        }
    }
    System.out.println(numberOfProblemsSolved);


}
}
